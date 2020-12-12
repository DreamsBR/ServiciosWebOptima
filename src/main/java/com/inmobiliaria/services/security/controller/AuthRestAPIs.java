package com.inmobiliaria.services.security.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inmobiliaria.services.security.message.request.ChangePasswordAdminForm;
import com.inmobiliaria.services.security.message.request.ChangePasswordForm;
import com.inmobiliaria.services.security.message.request.ChangeRoleAdminForm;
import com.inmobiliaria.services.security.message.request.LoginForm;
import com.inmobiliaria.services.security.message.request.SendEmailChangePassordForm;
import com.inmobiliaria.services.security.message.request.SignUpForm;
import com.inmobiliaria.services.security.message.response.JwtResponse;
import com.inmobiliaria.services.security.model.Role;
import com.inmobiliaria.services.security.model.RoleName;
import com.inmobiliaria.services.security.model.User;
import com.inmobiliaria.services.security.repository.RoleRepository;
import com.inmobiliaria.services.security.repository.UserRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import com.inmobiliaria.services.email.model.EmailBody;
import com.inmobiliaria.services.email.services.EmailService;
import com.inmobiliaria.services.security.jwt.JwtProvider;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/auth")
@Api(value = "auth", produces = "application/json", tags = { "Controlador auth" })
public class AuthRestAPIs {
	@Autowired
	EmailService emailService;
	
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtProvider jwtProvider;

    @Value("${app.urlChangePassword}")
    private String urlChangePassword;
    
    @PostMapping("/signin")
	@ApiOperation(value = "signin", tags = { "Controlador auth" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = JwtResponse.class)
	})
    public ResponseEntity<JwtResponse> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateJwtToken(authentication);
        return new ResponseEntity<>(new JwtResponse(jwt), HttpStatus.OK);
    }

    @PostMapping("/signup")
	@ApiOperation(value = "signup", tags = { "Controlador auth" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = String.class)
	})
    public ResponseEntity<String> registerUser(@Valid @RequestBody SignUpForm signUpRequest) {
        if(userRepository.existsByUsername(signUpRequest.getUsername())) {
            return new ResponseEntity<>("Fail -> Username is already taken!",
                    HttpStatus.BAD_REQUEST);
        }

        if(userRepository.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity<>("Fail -> Email is already in use!",
                    HttpStatus.BAD_REQUEST);
        }

        // Creating user's account
        User user = new User(signUpRequest.getName(), signUpRequest.getUsername(),
                signUpRequest.getEmail(), signUpRequest.getIdColaborador(), encoder.encode(signUpRequest.getPassword()));

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        strRoles.forEach(role -> {
        	switch(role) {
	    		case "ROLE_ADMIN":
	    			Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN).get();
	    			roles.add(adminRole);
	    			
	    			break;
	    		case "ROLE_GERENCIA":
	            	Role gerenciaRole = roleRepository.findByName(RoleName.ROLE_GERENCIA).get();
	            	roles.add(gerenciaRole);
	            	
	    			break;
	    		case "ROLE_EJECUTIVO":
	            	Role ejecutivoRole = roleRepository.findByName(RoleName.ROLE_EJECUTIVO).get();
	            	roles.add(ejecutivoRole);
	            	
	    			break;
	    		default:
	        		Role userRole = roleRepository.findByName(RoleName.ROLE_USER).get();
	        		roles.add(userRole);        			
        	}
        });
        
        user.setRoles(roles);
        userRepository.save(user);

        return ResponseEntity.ok().body("User registered successfully!");
    }
    @GetMapping("/roles")
	@ApiOperation(value = "roles", tags = { "Controlador auth" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = Role.class)
	})
    public List<Role> roles() {
        return roleRepository.findAll();
    }
    
    @PostMapping("/changepassword")
	@ApiOperation(value = "Change Password", tags = { "Controlador auth" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = String.class)
	})
    public ResponseEntity<String> changepassword(@Valid @RequestBody ChangePasswordForm changePasswordFormRequest) {

        boolean validToken = jwtProvider.validateJwtToken(changePasswordFormRequest.getToken());
        boolean validPassword = changePasswordFormRequest.getPassword().equals(changePasswordFormRequest.getRepeatPassword());
        
        if ( validToken && validPassword ) {
            User user =  userRepository.findByUsername(jwtProvider.getUserNameFromJwtToken(changePasswordFormRequest.getToken())).get();
            user.setPassword(encoder.encode(changePasswordFormRequest.getPassword()));

            userRepository.save(user);
            return ResponseEntity.ok().body("Password registered successfully!");
        }else {
        	return new ResponseEntity<>("token invalido ó password diferentes", HttpStatus.BAD_REQUEST);
        }
        
    }
    
    @PostMapping("/sendemailchangepassord")
	@ApiOperation(value = "Change Password", tags = { "Controlador auth" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = String.class)
	})
    public ResponseEntity<String> sendEmailChangePassord(@Valid @RequestBody SendEmailChangePassordForm sendEmailChangePassordFormRequest) {
    	User user =  userRepository.findByUsername(sendEmailChangePassordFormRequest.getUsername()).get();
        if ( user == null )
        	return new ResponseEntity<>("error username", HttpStatus.BAD_REQUEST);
        
    	String token = jwtProvider.generateJwtTokenChangePassword(sendEmailChangePassordFormRequest.getUsername());
        
        sendEmail(user.getEmail(), token);
        
        return ResponseEntity.ok().body("send successfully!");
    }
    
    private void sendEmail(String email, String token) {
    	String link = urlChangePassword + "?token=" + token;
    	String content ="Hola, <br>Recupera el acceso a la intranet restableciendo tu contraseña. Para restablecerla haz clic en el siguiente enlace y sigue las instrucciones. <a href='" + link + "'>restablecer contraseña<a/>";
    	
    	EmailBody emailBody = new EmailBody();   	
    	emailBody.setEmail(email);
    	emailBody.setSubject("Solicitud Change Password");
    	emailBody.setContent(content);
    	emailService.sendEmail(emailBody);
    }
    
    @PostMapping("/changepasswordadmin")
	@ApiOperation(value = "Change Password", tags = { "Controlador auth" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = String.class)
	})
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> changepasswordadmin(@Valid @RequestBody ChangePasswordAdminForm changePasswordFormRequest) {

            User user =  userRepository.findByUsername(changePasswordFormRequest.getUserName()).get();
            user.setPassword(encoder.encode(changePasswordFormRequest.getPassword()));

            Set<String> strRoles = changePasswordFormRequest.getRole();
            Set<Role> roles = new HashSet<>();

            strRoles.forEach(role -> {
            	switch(role) {
    	    		case "ROLE_ADMIN":
    	    			Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN).get();
    	    			roles.add(adminRole);
    	    			
    	    			break;
    	    		case "ROLE_GERENCIA":
    	            	Role gerenciaRole = roleRepository.findByName(RoleName.ROLE_GERENCIA).get();
    	            	roles.add(gerenciaRole);
    	            	
    	    			break;
    	    		case "ROLE_EJECUTIVO":
    	            	Role ejecutivoRole = roleRepository.findByName(RoleName.ROLE_EJECUTIVO).get();
    	            	roles.add(ejecutivoRole);
    	            	
    	    			break;
    	    		default:
    	        		Role userRole = roleRepository.findByName(RoleName.ROLE_USER).get();
    	        		roles.add(userRole);        			
            	}
            });
            user.setRoles(roles);
            userRepository.save(user);
            return ResponseEntity.ok().body("Password registered successfully!");
    }
    
    
    @PostMapping("/changeroleadmin")
	@ApiOperation(value = "Change role", tags = { "Controlador auth" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = String.class)
	})
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> changeroleadmin(@Valid @RequestBody ChangeRoleAdminForm changeRoleAdminForm) {

            User user =  userRepository.findByUsername(changeRoleAdminForm.getUserName()).get();

            Set<String> strRoles = changeRoleAdminForm.getRole();
            Set<Role> roles = new HashSet<>();

            strRoles.forEach(role -> {
            	switch(role) {
    	    		case "ROLE_ADMIN":
    	    			Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN).get();
    	    			roles.add(adminRole);
    	    			
    	    			break;
    	    		case "ROLE_GERENCIA":
    	            	Role gerenciaRole = roleRepository.findByName(RoleName.ROLE_GERENCIA).get();
    	            	roles.add(gerenciaRole);
    	            	
    	    			break;
    	    		case "ROLE_EJECUTIVO":
    	            	Role ejecutivoRole = roleRepository.findByName(RoleName.ROLE_EJECUTIVO).get();
    	            	roles.add(ejecutivoRole);
    	            	
    	    			break;
    	    		default:
    	        		Role userRole = roleRepository.findByName(RoleName.ROLE_USER).get();
    	        		roles.add(userRole);        			
            	}
            });
            user.setRoles(roles);
            userRepository.save(user);
            return ResponseEntity.ok().body("Role registered successfully!");
    }
}
@PostMapping("/register")
@Operation(summary = "Register a new user")
public User register(@RequestBody User user) {
    return userService.register(user);
}

@PostMapping("/login")
@Operation(summary = "Authenticate user and return JWT")
public Map<String, Object> login(@RequestBody User loginRequest) {
    User user = userService.findByEmail(loginRequest.getEmail());
    if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
        throw new IllegalArgumentException("Invalid credentials");
    }
    String token = jwtTokenProvider.generateToken(user.getId(), user.getEmail(), user.getRole());
    return Map.of(
        "token", token,
        "userId", user.getId(),
        "email", user.getEmail(),
        "role", user.getRole()
    );
}
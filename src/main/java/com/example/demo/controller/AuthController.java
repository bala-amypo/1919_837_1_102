@PostMapping("/register")
public ResponseEntity<?> register(@RequestBody RegisterRequest request) {

    String encodedPassword = passwordEncoder.encode(request.getPassword());

    User user = new User(
            null,
            request.getName(),
            request.getEmail(),
            encodedPassword,
            "USER",
            null
    );

    userRepository.save(user);

    return ResponseEntity.ok("User registered successfully");
}

## Feature http-client documentation

- [Micronaut Micronaut HTTP Client documentation](https://docs.micronaut.io/latest/guide/index.html#httpClient)



## Generation of Certificates
https://www.scottbrady91.com/OpenSSL/Creating-RSA-Keys-using-OpenSSL

## JWK from Priv/Pub key
Create JWK from Public/Priv RSA key -> https://russelldavies.github.io/jwk-creator/

## JWK Specification
https://datatracker.ietf.org/doc/html/rfc7517


## RSA Key Parameters
https://datatracker.ietf.org/doc/html/rfc7518#section-6.3
https://www.gnupg.org/documentation/manuals/gcrypt-devel/RSA-key-parameters.html

- kty -> cryptographic algorithm family  Eg: RSA
- use -> use of the public key Eg: sig
- kid -> used to match a specific key
- n -> contains the modulus value for the RSA public key
- e -> exponent value for the RSA public key
- d -> the private exponent value for the RSA private key
- p -> contains the first prime factor
- q -> contains the second prime factor
- dp -> contains the Chinese Remainder Theorem (CRT) exponent of the first factor
- dq -> contains the Chinese Remainder Theorem (CRT) exponent of the second factor
- qi -> contains the CRT coefficient of the second factor


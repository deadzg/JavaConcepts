package jwks.gen.controller;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.KeyUse;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.gen.RSAKeyGenerator;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.util.UUID;

@Controller("/jwks")
public class JwksController {

    @Get(produces = MediaType.TEXT_PLAIN)
    public String index() throws JOSEException {
        // Generate 2048-bit RSA key pair in JWK format, attach some metadata
        RSAKey jwk = new RSAKeyGenerator(2048)
                .keyUse(KeyUse.SIGNATURE) // indicate the intended use of the key
                .keyID(UUID.randomUUID().toString()) // give the key a unique ID
                .generate();

        // Output the private and public RSA JWK parameters
        System.out.println(jwk);

        // Output the public RSA JWK parameters only
        System.out.println(jwk.toPublicJWK());


        // Test Private Key
        JWK myJwk = JWK.parseFromPEMEncodedObjects("-----BEGIN RSA PRIVATE KEY-----\n"
                + "MIIG5AIBAAKCAYEA3LBEtAbcDVun/iJFeMQPexRH+zoIXQa1defMZ/VarLfAUxeG\n"
                + "YqLxFrPJcvMIl3agj7Q/FQr728A4qolkB3V5H2jpET2KrB+OliNPMWzqz1ne9RUC\n"
                + "806rw9tueHEOiX0DGPxnBVsGsNeLxdB4+oACBmVdb4vPODh8aRILtZ7Yha3IQOsW\n"
                + "UVwAhFZNIYWXLrXLulQBy+TlJYLZ2hlKNkYT+pKpiZNvzAdEAk8i+IWRxpF7bNoO\n"
                + "6CB2zoHZJRTeYLXx1rhSW44Stdjsi1jmCseVFY+HPJBMv9I+xxFNGqQ/kNRx+ahF\n"
                + "g8NN8Tf0/uSDg4o3uLfC448+mSCpoI139YJSWivGnTzYNAYAF2TIipZXpEa5Jrzw\n"
                + "EOZLljkVJqqNxH0EOcuhTh4Tdg+g+J0BrB4TuDt2TauLbuWBuRoWaOA7lBEFq9yW\n"
                + "xTm0XJRPnCr4P+fV5TaGU1JZst+Hxik6I9ZoCbtBFD443tA2dD5+bc1TmjaZJRvd\n"
                + "ef8Tide7gkoRv/bfAgMBAAECggGBAKma8oIlD3NYsKg4MIoarAccVCG4vPq5kDYY\n"
                + "OljfEJvS8IUrfEVMEtsuuzCTpVO6gLVQgnaqpVuCxEoUIwM0fizslMqCMJQOAKhU\n"
                + "ZKWInoFTAW37gvP4zztL5f+8a76wi/Pk70wHZAH+9dXGXWOvg17lAkUa/tunVb3u\n"
                + "d39Sn/dE0rVJtzI58c/C/642nDTy1KrTqznHJXCJuuHKM+W4P9yAYLlxzSbRoqvf\n"
                + "o/G5vYoM/v1uLKyrXoNg+cBs5GcRDGlV7YpAessqvv8OW66YWT5deJ8vn1NtE82b\n"
                + "1XG7Ve9rBcA33RTSRMK1ZvQ1Kb/1CVK0DEmMsTp6GiBN1Pw2qGYvd6GHQJ9NSDOQ\n"
                + "r/y2BsByPT/VfT//kzOMoSiQ624n8iK6rdXDjjNLMbLOQ/YJ+X9uYBUScVrzyb+J\n"
                + "tQMFKcKr3f57nM0ZpUu9YknWUG5ZoflowDfKxePt8l09Cez7DtMWrfc1JyCfLX1+\n"
                + "EaJU5rMJAi1jwjbDQvvebT595pgFeQKBwQDzQRiWJvyCLXzMsbEm3xjQQaFFbi4S\n"
                + "4SRr3dlqniynkOyQEqcDgMkK9HCzgmo8DKlz9ajITQgh8qQ+64ki0zKQ3bOtUZWm\n"
                + "e/BSwwl3mvYbXcHlyTPpDoZgO6TFaEKaurR1rAxr5Dfn9aJbGZXfIpAdk99r99HO\n"
                + "/HnKr0luciE8VbXT7e+qrXmnQd1zrmWIhwyaOKsWOhCeCO2pU7EifZcRKFE7yu/a\n"
                + "bx7d9vMuHhAyBpxghcZ5NGGk6fkRS4aSEWUCgcEA6EB8VpWqDyXU/jSRWtfPV/1e\n"
                + "QQ4ClVC+KbKIwe+uZFtMEC0/5gDfigwwNAr5/VXFpqOKL957NUag2+BpuObBlu+o\n"
                + "pyvGGa9UlqodYal3SUzXoPsRokaRJKYRqGlDO9YU74Ka1VGuLsIlNpgWqLKMnma3\n"
                + "Y2ZIc47XEdn2I6epEhXfNt0bGOir3MFVvA8+NpJ3zUmxK+kLH/hgAFLAZsRfRTk3\n"
                + "iEpjXzxmTJ5E8BZA9mhjkYVS9gJLt1mjnYH/NmTzAoHBANyScFrm6xyXZoytq3cV\n"
                + "4QgmGrg8WibgZAgzWEwnNVKURQ22/B5fDu2SDQeY//+Hc7gkT3Gg9/jgbjJnnSgo\n"
                + "3bcicSR9z/bwd1B0bgc4SmUyNPnJ4fo4I3zrWFNwYMSw+6Wf5nuGq3L39soofw+f\n"
                + "5ZIMXhEm2+aWZVF2dF1ju+NbzM5o+GOJfcA+JzIYNxT/cFv/epNi/2JtsiNSMlKW\n"
                + "Ev+J0W8oaylkjVaz8Hom5ISYHgAgDYImD0xcpG4cT9/vSQKBwCycFkXbQWrfbWXW\n"
                + "WwUD5sOT2wLL2hssAxqnPDVkAC8uihGhX2CiUk2Fwcx9Pz81tl0nlGdVaHz3L/aL\n"
                + "yELHr+954P8bHVXZo3m8+x/DGTJvHAvDrcNpon9Tlpiuf0eC+0p135+RrM82Y0d1\n"
                + "NwT4JqJWQGtLPidUDGNVZj26+nKK2PEEzyudpUUlrX4Nv3lj8LbxrKIuhQCDCI2H\n"
                + "V4VlupblQpFfGG82fr/AtqUW4StzKYzN+v1du4VgJlkemxKrmQKBwEA47NKgRB4o\n"
                + "ULMAGMU+w7ABxFBZk28AHdd0eaZYTDJ0vnksPUmKFByk3JrnbdvHIWKAjHhwbXk/\n"
                + "PbyYjp7ODb1wJhYfDhT32If1MZAVl0iMU9Xba3svSLmVHzEnQriTzn/4rktW3Q7T\n"
                + "Gs1zt5rOhm7lRVWkpT0TMueThqqdClZPsaYWt2BXWCxWBm+W+P9MRfteBvV6ntOA\n"
                + "1DeEySDOiKZBnYOPEkOZ4WsTg3nZZtm72CDjb4Rg8wq7+dox9dXMsQ==\n"
                + "-----END RSA PRIVATE KEY-----");

        System.out.println(myJwk.toString());

        return "JWKS WIP...";
    }
}
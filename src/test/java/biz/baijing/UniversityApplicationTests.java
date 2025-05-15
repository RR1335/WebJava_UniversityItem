package biz.baijing;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import io.jsonwebtoken.*;
import java.util.Date;

//@SpringBootTest
class UniversityApplicationTests {

    @Test
    void contextLoads() {
    }
    

//        Map<String, Object> claims = new HashMap<>();
//        claims.put("id",1);
//        claims.put("name","baijing");
//        Jwts.builder()    @Test
//    public void testJWT() {
//
//        Date expiration = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24);
//        Date notBefore = new Date(System.currentTimeMillis());
//        String jws = Jwts.builder()
//
//                .issuer("Baijing")
//                .subject("Happy Birthday")
//                .audience().add("wucaimu").and()
//                .expiration(expiration) //a java.util.Date
//                .notBefore(notBefore) //a java.util.Date
//                .issuedAt(new Date()) // for example, now
//                .id(UUID.randomUUID().toString()) //just an example id
//                .compact();
//
//
///*        SecretKey key = Jwts.SIG.HS256.key().build();
//
//        String jws = Jwts.builder().subject("BaiJing").signWith(key).compact();*/
//
//        System.out.println(jws);
//                .signWith(SignatureAlgorithm.HS256, "baijing")
//                .setClaims(claims)
//                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000));
//}

        @Test
        public void testJJwt() {

            String id = UUID.randomUUID().toString();
            String issuer = "Baijing";
            String subject = "Happy Birthday";
            Long ttlMillis = (long) (1000 * 60 * 60 * 24);

            //The JWT signature algorithm we will be using to sign the token
            SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

            long nowMillis = System.currentTimeMillis();
            Date now = new Date(nowMillis);

            //We will sign our JWT with our ApiKey secret
//        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(apiKey.getSecret());
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary("sdalfkjleiwfjioerjglni*^#&8dsfasdfrghtgru39847j*(&&^#*yr894yr8934thfklKNDhfiuerhfgoie8gorggkhsdlrghdsioghviosrhgvosrihtgor45ut9034759384509347328o5rh");
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        //Let's set the JWT Claims
        JwtBuilder builder = Jwts.builder().setId(id)
                .issuedAt(now)
                .subject(subject)
                .issuer(issuer)
                .signWith(signatureAlgorithm, signingKey);

        //if it has been specified, let's add the expiration
        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }

        System.out.println(builder.compact());
        //Builds the JWT and serializes it to a compact, URL-safe string
//        return builder.compact();
    }

    @Test
    public void testJwetsRead() {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary("sdalfkjleiwfjioerjglni*^#&8dsfasdfrghtgru39847j*(&&^#*yr894yr8934thfklKNDhfiuerhfgoie8gorggkhsdlrghdsioghviosrhgvosrihtgor45ut9034759384509347328o5rh");
        SecretKey signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
            String jwsString = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxNzE0ZDcwYi1lNjJhLTQ2ZWYtYWE0ZS0wYTNmNDA5ZGJhMjMiLCJpYXQiOjE3NDczMTA1MDUsInN1YiI6IkhhcHB5IEJpcnRoZGF5IiwiaXNzIjoiQmFpamluZyIsImV4cCI6MTc0NzM5NjkwNX0.n0R0BLwknSCb19q-Tn9g6L9MoUGK6t-CxeNmHvCUQ40";

        Jws<Claims> claimsJws = Jwts.parser()
                                    .verifyWith(signingKey)
                                    .build()
                                    .parseSignedClaims(jwsString);
        System.out.println(claimsJws.getBody());
        }


    //Sample method to validate and read the JWT
//    private void parseJWT() {
//        String jwt = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI3MTlkYzM4NC04ODQ1LTRmMGEtYTZlNS03N2NjZTcxM2ZhMjEiLCJpYXQiOjE3NDczMDUzMDMsInN1YiI6IkhhcHB5IEJpcnRoZGF5IiwiaXNzIjoiQmFpamluZyIsImV4cCI6MTc0NzM5MTcwM30.mI8cMmFGaZU0WT_HLF2Ej2YNGr-egpPTmlw7T0bXU9U";
//        //This line will throw an exception if it is not a signed JWS (as expected)
//        Claims claims = Jwts.parser()
//                .setSigningKey(DatatypeConverter.parseBase64Binary( "sdalfkjleiwfjioerjglni*^#&8dsfasdfrghtgru39847j*(&&^#*yr894yr8934thfklKNDhfiuerhfgoie8gorggkhsdlrghdsioghviosrhgvosrihtgor45ut9034759384509347328o5rh"))
//                .parseSignedClaims(jwt).getBody();
//        System.out.println("ID: " + claims.getId());
//        System.out.println("Subject: " + claims.getSubject());
//        System.out.println("Issuer: " + claims.getIssuer());
//        System.out.println("Expiration: " + claims.getExpiration());
//    }

}

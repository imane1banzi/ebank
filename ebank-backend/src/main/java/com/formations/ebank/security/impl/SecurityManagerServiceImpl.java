package com.formations.ebank.security.impl;

import com.formations.ebank.security.SecurityManagerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

@Service
@Slf4j
@RequiredArgsConstructor
public class SecurityManagerServiceImpl implements SecurityManagerService {

    private static final String ALGORITHM = "AES";
    private static SecretKeySpec secretKey;
    private static byte[] key;
    protected final Integer MIN = 10;
    protected final Integer MAX = 100;

    public void prepareSecreteKey(String myKey) {
        MessageDigest sha = null;
        try {
            key = myKey.getBytes(StandardCharsets.UTF_8);
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String crypterMotDePasse(String motDePasse, String userSecretKey) {


        try {
            prepareSecreteKey(userSecretKey);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(motDePasse.getBytes(StandardCharsets.UTF_8)));
        } catch (Exception e) {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;

    }

    @Override
    public String decrypterMotDePasse(String motDePasse, String userSecretKey) {
        try {
            prepareSecreteKey(userSecretKey);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(motDePasse)));
        } catch (Exception e) {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }

    @Override
    public String generateAutoPassword() {
        try {
            CharacterRule alphabets = new CharacterRule(EnglishCharacterData.Alphabetical);
            CharacterRule digits = new CharacterRule(EnglishCharacterData.Digit);
            CharacterRule special = new CharacterRule(EnglishCharacterData.Special);

            PasswordGenerator passwordGenerator = new PasswordGenerator();
            return passwordGenerator.generatePassword(8, alphabets, digits, special);

        } catch (Exception e) {
            log.error("Error generation password auto", SecurityManagerServiceImpl.class);
            return null;
        }
    }

    @Override
    public String generateAutoLogin(String nom, String prenom) {
        try {

            int randomNum = (int) (Math.random() * (MAX - MIN + 1)) + MIN;

            String premierCaraterePrenom = prenom.substring(0, 1).toLowerCase();
            return premierCaraterePrenom.
                    concat("." + nom.toLowerCase() + randomNum);
        } catch (Exception e) {
            log.error("Error generate login auto", e);
            return null;
        }
    }


}


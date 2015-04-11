package org.pretty.common.utils;

import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 * RSA 加密算法
 * 
 * @author lazyp
 * @date 2015-04-11
 * @version 1.0.1
 */
public final class RSAUtils {
    private static final String KEY_ALGORTHM = "RSA";//

    /**
     * 初始化密钥
     * 
     * @return
     * @throws Exception
     */
    public static KeyPair generateKeyPair(int bit) throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(KEY_ALGORTHM);
        keyPairGenerator.initialize(bit);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        return keyPair;
    }

    private static byte[] cipher(byte[] data, Key key, int mode) throws InvalidKeyException, NoSuchAlgorithmException,
            NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORTHM);
        // 对数据加解密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(mode, key);
        return cipher.doFinal(data);
    }

    /**
     * 用私钥加密
     * 
     * @param data
     *            加密数据
     * @param key
     *            密钥
     * @return
     * @throws Exception
     */
    public static byte[] encryptByPrivateKey(byte[] data, PrivateKey privateKey) throws Exception {
        return cipher(data, privateKey, Cipher.ENCRYPT_MODE);
    }

    /**
     * 用私钥加密
     * 
     * @param data
     *            加密数据
     * @param key
     *            密钥
     * @return
     * @throws Exception
     */
    public static byte[] encryptByPrivateKey(String dataStr, PrivateKey privateKey) throws Exception {
        return cipher(dataStr.getBytes(Charset.forName("UTF-8")), privateKey, Cipher.ENCRYPT_MODE);
    }

    /**
     * 用私钥解密
     * 
     * @param key
     *            密钥
     * @return
     * @throws Exception
     */
    public static byte[] decryptByPrivateKey(byte[] data, PrivateKey privateKey) throws Exception {
        return cipher(data, privateKey, Cipher.DECRYPT_MODE);
    }

    /**
     * 用私钥解密
     * 
     * @param key
     *            密钥
     * @return
     * @throws Exception
     */
    public static byte[] decryptByPrivateKey(String dataStr, PrivateKey privateKey) throws Exception {
        return cipher(dataStr.getBytes(Charset.forName("UTF-8")), privateKey, Cipher.DECRYPT_MODE);
    }

    /**
     * 用公钥加密
     * 
     * @param data
     *            加密数据
     * @param key
     *            密钥
     * @return
     * @throws Exception
     */
    public static byte[] encryptByPublicKey(byte[] data, PublicKey publicKey) throws Exception {
        return cipher(data, publicKey, Cipher.ENCRYPT_MODE);
    }

    /**
     * 用公钥加密
     * 
     * @param data
     *            加密数据
     * @param key
     *            密钥
     * @return
     * @throws Exception
     */
    public static byte[] encryptByPublicKey(String dataStr, PublicKey publicKey) throws Exception {
        return cipher(dataStr.getBytes(Charset.forName("UTF-8")), publicKey, Cipher.ENCRYPT_MODE);
    }

    /**
     * 用公钥解密
     * 
     * @param data
     *            加密数据
     * @param key
     *            密钥
     * @return
     * @throws Exception
     */
    public static byte[] decryptByPublicKey(byte[] data, PublicKey publicKey) throws Exception {
        return cipher(data, publicKey, Cipher.DECRYPT_MODE);
    }

    /**
     * 用公钥解密
     * 
     * @param data
     *            加密数据
     * @param key
     *            密钥
     * @return
     * @throws Exception
     */
    public static byte[] decryptByPublicKey(String dataStr, PublicKey publicKey) throws Exception {
        return cipher(dataStr.getBytes(Charset.forName("UTF-8")), publicKey, Cipher.DECRYPT_MODE);
    }
}

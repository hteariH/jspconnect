package com.templatemonster.jspconnect;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Hashtable;
import java.util.Map;
import java.util.Vector;
import java.util.stream.Collectors;

/**
 * user: alekseyb
 * date: 2/9/18
 */
public class Algoritm {
    public static String md5(String sum) {
        String hexString = null;
        try {
            MessageDigest algorithm = MessageDigest.getInstance("MD5");
            algorithm.reset();
            algorithm.update(sum.getBytes());
            byte messageDigest[] = algorithm.digest();
            HexDump.setWithByteSeparator(false);
            hexString = HexDump.byteArrayToHexString(messageDigest);

        } catch (NoSuchAlgorithmException nsae) {
            return null;
        }
        return hexString;
    }

    public static String md5Sum(Vector<Hashtable<String, String>> itemList, String hashCode) {
        StringBuffer sum = new StringBuffer();
        for (Hashtable<String, String> item : itemList) {
            for (String attrib : item.values()) {
                sum.append(attrib);
            }
        }
        sum.append(hashCode);

        return md5(sum.toString());
    }

    public static String md5Sum(Map<String,String> itemList, String hashCode) {
        String collect = itemList.values().stream().collect(Collectors.joining(""))+hashCode;

        return md5(collect);
    }
}
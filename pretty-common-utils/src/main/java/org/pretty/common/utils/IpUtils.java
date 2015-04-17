package org.pretty.common.utils;

public final class IpUtils {

    /**
     * eg. <code>
     *  IpUtils.isValidNetIp("12.1.0.2") return true;
     *  IpUtils.isValidNetIp("12.1.0") return false;
     *  IpUtils.isValidNetIp("12.1.0.a") return false;
     *  IpUtils.isValidNetIp("12.1.0.256") return false;
     * </code>
     * 
     * @param netIp
     * @return
     */
    public static boolean isValidNetIp(String netIp) {
        if (StrUtils.isBlank(netIp)) {
            return false;
        }

        String[] metas = netIp.split("\\.");
        if (metas.length != 4) {
            return false;
        }

        for (String meta : metas) {
            int num = -1;
            try {
                num = Integer.parseInt(meta);
            } catch (Exception e) {
                return false;
            }

            if (num > 255 || num < 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * 
     * @param ip
     * @return if transform long fail , it return -1
     */
    public static long netIpToLong(String netIp) {
        if (StrUtils.isBlank(netIp) || !isValidNetIp(netIp)) {
            return -1;
        }

        long lip = 0;

        String[] metas = netIp.split("\\.");
        lip |= Long.parseLong(metas[0]) << 24;
        lip |= Long.parseLong(metas[1]) << 16;
        lip |= Long.parseLong(metas[2]) << 8;
        lip |= Long.parseLong(metas[3]);

        return lip;
    }

    /**
     * 
     * @param ip
     * @return
     */
    public static String longToNetIp(long longIp) {
        if (longIp > 4294967295L) {
            return StrUtils.EMPTY;
        }

        String[] ip = new String[4];

        ip[3] = String.valueOf(longIp & 0xFF);
        ip[2] = String.valueOf((longIp >>> 8) & 0xFF);
        ip[1] = String.valueOf((longIp >>> 16) & 0xFF);
        ip[0] = String.valueOf((longIp >>> 24) & 0xFF);

        return ArrayUtils.join(ip, '.');
    }

    public static void main(String[] args) {
    }
}

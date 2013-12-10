package org.pretty.common.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.imageio.ImageIO;

/**
 * @author hxl
 * @version 9:50:54 PM Sep 3, 2013
 */
public final class ImageUtils {
    private static final int LINE_HEIGHT = 12;

    /**
     * text 转为 image
     * @param text
     * @return
     */
    public static BufferedImage textTransToImage(String text) {
        int charCount = text.length();
        int lineCount = (int) Math.ceil(charCount / 16.0);
        int height = (int) Math.ceil(lineCount * LINE_HEIGHT) + 12;
        int width = 7 * charCount;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = image.getGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, width, height);
        graphics.setFont(new Font("宋体", Font.PLAIN, 12));
        graphics.setColor(Color.BLACK);
        int line = 1;
        for (int i = 0; i < charCount; i += 16) {
            String str = "";
            if (i + 16 > charCount) {
                str = text.substring(i, charCount);
            } else {
                str = text.substring(i, i + 16);
            }
            graphics.drawString(str, 1, 1 + LINE_HEIGHT * line++);
        }
        return image;
    }

    /**
     * image to byte
     * @param image
     * @return
     * @throws IOException
     */
    public static byte[] imageToByte(BufferedImage image) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ImageIO.write(image, "png", out);
        try {
            return out.toByteArray();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    /**
     * 下载图片
     * @param imageUrl
     * @return
     */
    public static byte[] fetchImageFromUrl(String imageUrl) {
        int lastDotIndex = imageUrl.lastIndexOf(".");
        if (lastDotIndex > -1) {
            String suffix = imageUrl.substring(lastDotIndex + 1);
            if ("jpg".equals(suffix) || "gif".equals(suffix) || "png".equals(suffix) || "jpeg".equals(suffix)) {
                URLConnection conn = null;
                InputStream inputStream = null;
                try {
                    conn = new URL(imageUrl).openConnection();
                    conn.setConnectTimeout(10000);
                    conn.setReadTimeout(9990);
                    inputStream = conn.getInputStream();
                    ByteArrayOutputStream out = new ByteArrayOutputStream();
                    byte[] content = new byte[256];
                    int len = -1;
                    while ((len = inputStream.read(content)) > 0) {
                        out.write(content, 0, len);
                    }
                    return out.toByteArray();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * 从image url中获取名字
     * @param url
     * @return
     */
    public static String getImageTitleFromUrl(String url) {
        int index = url.lastIndexOf("/");
        if (index > -1) {
            return url.substring(index + 1);
        }
        return "";
    }

    public static void main(String[] args) {
        ImageUtils.fetchImageFromUrl("http://getpic.jinyi360.com/images/logo.gif");
    }
}

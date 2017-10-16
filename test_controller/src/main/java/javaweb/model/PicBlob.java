/**
 * Copyright (c) 2017 Qunar.com. All Rights Reserved.
 */
package javaweb.model;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;

import javax.imageio.stream.FileImageInputStream;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.mysql.jdbc.Blob;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * @author jintao.wang Date: 17-9-19 Time: 下午4:27
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Slf4j
public class PicBlob {
    private Integer id;

    private String name;

    private Blob picObj;

    public void setBlob(String fileName){
        Preconditions.checkArgument(!Strings.isNullOrEmpty(fileName));
        Preconditions.checkNotNull(picObj);

        name = fileName;
        byte[] buff = new byte[1024];
        int n = 0;
        FileImageInputStream fileImageInputStream = null;
        OutputStream outputStream = null;

        try {
            fileImageInputStream = new FileImageInputStream(new File(fileName));
            outputStream = picObj.setBinaryStream(0);

            while ((n = fileImageInputStream.read(buff)) >= 1){
                outputStream.write(buff);
            }

        } catch (IOException e) {
            log.error("setBlob() error!!",e);
        } catch (SQLException e) {
            log.error("setBlob() error!!",e);
        } finally {
            if (fileImageInputStream != null){
                try {
                    fileImageInputStream.close();
                } catch (IOException e) {
                    log.error("fileImageInputStream.close() error!!",e);
                }
            }

            if(outputStream != null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    log.error("outputStream.close() error!!",e);
                }
            }

        }
    }

}

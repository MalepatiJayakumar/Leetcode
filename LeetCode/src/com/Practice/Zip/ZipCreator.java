package com.Practice.Zip;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.*;

public class ZipCreator {
	public static void createZip(InputStream inputStream) throws IOException {

		int BUFFER_SIZE = 4096;
		int count = 0;
		byte[] buffer = new byte[BUFFER_SIZE];
		ZipOutputStream zipOutputStream = null;

		try (BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream)) {
			int i = 1;
			while (bufferedInputStream.available() > 0) {
				if (count == 0) {
					// Create a new zip file after every 25 files
					String zipFileName = "zip_" + i + ".zip";
					zipOutputStream = new ZipOutputStream(new FileOutputStream(zipFileName));
					i++;
				}

				// Get the next file from the input stream
				ZipEntry zipEntry = new ZipEntry("file_" + count + ".txt");
				zipOutputStream.putNextEntry(zipEntry);

				// Write the file content to the zip output stream
				int bytesRead;
				while ((bytesRead = bufferedInputStream.read(buffer)) != -1) {
					zipOutputStream.write(buffer, 0, bytesRead);
				}

				// Close the current entry and increment the file counter
				zipOutputStream.closeEntry();
				count++;

				// Close the zip output stream after every 25 files
				if (count % 25 == 0) {
					count = 0;
					zipOutputStream.close();
				}
			}
		}
		// Close the last zip output stream
		if (zipOutputStream != null) {
			zipOutputStream.close();
		}
	}
}

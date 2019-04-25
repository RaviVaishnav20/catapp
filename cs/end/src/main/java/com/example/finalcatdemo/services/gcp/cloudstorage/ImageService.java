
package com.example.finalcatdemo.services.gcp.cloudstorage;


import com.google.cloud.storage.*;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

@Service
public class ImageService {

	private static Storage storage = StorageOptions.getDefaultInstance().getService();

	@Value("${google.storage.bucket}")
	private String bucketName;



	public String saveImage(MultipartFile file) throws IOException {

		String fileName = System.nanoTime() + file.getOriginalFilename();

		BlobInfo blobInfo = storage.create(
				BlobInfo.newBuilder(bucketName, fileName).setContentType(file.getContentType())
						.setAcl(new ArrayList<>(Arrays.asList(Acl.of(Acl.User.ofAllUsers(), Acl.Role.READER)))).build(),
				file.getInputStream());



		return "https://storage-download.googleapis.com/" + bucketName + "/" + fileName;


	}
}
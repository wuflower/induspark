package com.khbr.induspark.controller;

import com.khbr.induspark.entity.User;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;



@Controller
public class UploadDemoController {
	/**
	 * 跳转到上传页面
	 * @return
	 */
	@GetMapping("/gotoUploadForm")
	public String index() {
	    return "uploaddemo/upload_form";
	}
	
	/**
	 * 上传单个文件
	 * 通过MultipartFile读取文件信息，如果文件为空跳转到结果页并给出提示；
	 * 如果不为空读取文件流并写入到指定目录，最后将结果展示到页面
	 * @param origFile
	 * @param redirectAttributes
	 * @return
	 */
	@PostMapping("/upload") 
	public String uploadSingleFile(@RequestParam("file") MultipartFile origFile,HttpServletRequest request
	                     ) {
		
	    if (origFile.isEmpty()) {
	        //redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
	        return "uploaddemo/upload_result";
	    }

	    try {
	    	 String contentType = origFile.getContentType();
	         String fileName = origFile.getOriginalFilename();
	         byte[] bytes = origFile.getBytes();
	         System.out.println("上传文件名为-->" + fileName);
	         System.out.println("上传文件类型为-->" + contentType);
	         System.out.println("上传文件大小为-->"+bytes.length);
	         
	         //String filePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/myres/";
	         //String filePath = "f:/myres";
	         //String filePath = request.getSession().getServletContext().getRealPath("./imgupload");
	         
	         String filePath=ResourceUtils.getURL("classpath:").getPath();
	         File parentPath = new File(filePath, "static");
			 String nn = parentPath.getAbsolutePath().toString()+fileName.toString();
	         System.out.println("上传目的地为-->"+nn);
	         try {
	        	 File destFile = new File(parentPath,fileName);//上传目的地
	             FileUtils.writeByteArrayToFile(destFile,origFile.getBytes());
	         } catch (Exception e) {
	             // TODO: handle exception
	         }

	        // Get the file and save it somewhere
	        
	     /*   Path path = Paths.get(UPLOADED_FOLDER + origFile.getOriginalFilename());
	        Files.write(path, bytes);

	        redirectAttributes.addFlashAttribute("message",
	                "You successfully uploaded '" + origFile.getOriginalFilename() + "'");*/

	         request.setAttribute("message",  "You successfully uploaded '" + origFile.getOriginalFilename() + "'");
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    return "uploaddemo/upload_result";
	}
	
	/**
	 * 上传多个文件，同时接受业务数据
	 * @param origFiles
	 * @param request
	 * @param user
	 * @return
	 */
	@PostMapping("/uploadMultiFiles") 
	public String uploadMultiFiles(@RequestParam("file") List<MultipartFile> origFiles,HttpServletRequest request
	           ,User user           ) {
		
		System.out.println("User=="+user);
	    if (origFiles.isEmpty()) {
	        //redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
	        return "uploaddemo/upload_result";
	    }

	    try {
	    	for (MultipartFile origFile : origFiles) {
	    		 String contentType = origFile.getContentType();
		         String fileName = origFile.getOriginalFilename();
		         byte[] bytes = origFile.getBytes();
		         System.out.println("上传文件名为-->" + fileName);
		         System.out.println("上传文件类型为-->" + contentType);
		         System.out.println("上传文件大小为-->"+bytes.length);
		         
		         //String filePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/myres/";
		         String filePath = "f:/myres";
		         //String filePath = request.getSession().getServletContext().getRealPath("imgupload");
		         System.out.println("上传目的地为-->"+filePath);
		         try {
		        	 File destFile = new File(filePath,fileName);//上传目的地
		             FileUtils.writeByteArrayToFile(destFile,origFile.getBytes());
		         } catch (Exception e) {
		             // TODO: handle exception
		         }

			}
	    	
	    	
	        // Get the file and save it somewhere
	        
	     /*   Path path = Paths.get(UPLOADED_FOLDER + origFile.getOriginalFilename());
	        Files.write(path, bytes);

	        redirectAttributes.addFlashAttribute("message",
	                "You successfully uploaded '" + origFile.getOriginalFilename() + "'");*/
			String fileName="";
			for (MultipartFile list:
				 origFiles) {

				fileName=fileName+list.getOriginalFilename()+";";
				
			}

	         request.setAttribute("message",  "You successfully uploaded '" +fileName + "'");
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    return "uploaddemo/upload_result";
	}
}

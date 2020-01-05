package cn.itcast.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

/**
 * @Author Lian Flower
 * @Date 2019/9/22 10:29
 * @Version 1.0
 */
@Component
@RequestMapping("/user")
public class UserController {

	/**
	 * 传统文件上传
	 * @return
	 */
	@RequestMapping("/fileupload1")
	public String fileupload1(HttpServletRequest request) throws Exception {
		System.out.println("传统文件上传...");
		// 1. 设置上传的位置
		// 上传位置为：项目部署到服务器后的根路径下的uploads目录下
		String realPath = request.getSession().getServletContext().getRealPath("/uploads/");
		// 判断uploads目录是否存在，如果不存在，就重新创建
		File file = new File(realPath);	// 创建文件对象
		if (!file.exists()) {	// 如果文件对象不存在，说明uploads目录不存在
			file.mkdirs();	// 则创建uploads目录
		}

		// 2. 解析request对象，获取上传文件项
		// 创建磁盘文件工厂对象
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		// 解析request
		List<FileItem> items = upload.parseRequest(request);
		for (FileItem item : items) {
			// 判断当前item对象，是普通表单项还是上传文件项
			if (item.isFormField()) {	//
				// 普通表单项
			} else {
				// 上传文件项
				// 获取上传文件的名称
				String filename = item.getName();
				// 将文件的名称设置为唯一值，防止覆盖的情况
				String uuid = UUID.randomUUID().toString().replace("-", "");// uuid生成的字符中会有-，我们可以将它替换为空字符串
				filename = uuid + "_" + filename;
				// 将文件上传到realPath路径下
				item.write(new File(realPath, filename));
				// 删除临时文件（上传文件大于10kb时，会产生临时文件，上传完成后可以删除临时文件）
				item.delete();
			}
		}
		return "success";
	}

	/**
	 * springMVC文件上传
	 * @return
	 */
	@RequestMapping("/fileupload2")						// 注意：MultipartFile对象用于获取解析过的上传文件项，形参的值，必须和form表单中上传文件项的name值相同
	public String fileupload2(HttpServletRequest request, MultipartFile upload) throws Exception {
		System.out.println("springMVC文件上传...");
		// 1. 设置上传的位置
		// 上传位置为：项目部署到服务器后的根路径下的uploads目录下
		String realPath = request.getSession().getServletContext().getRealPath("/uploads/");
		// 判断uploads目录是否存在，如果不存在，就重新创建
		File file = new File(realPath);	// 创建文件对象
		if (!file.exists()) {	// 如果文件对象不存在，说明uploads目录不存在
			file.mkdirs();	// 则创建uploads目录
		}

		// 获取上传文件的名称
		String filename = upload.getOriginalFilename();
		// 将文件的名称设置为唯一值，防止覆盖的情况
		String uuid = UUID.randomUUID().toString().replace("-", "");// uuid生成的字符中会有-，我们可以将它替换为空字符串
		filename = uuid + "_" + filename;
		// 将文件上传到realPath路径下
		upload.transferTo(new File(realPath, filename));
		return "success";
	}

	/**
	 * 跨服务器文件上传
	 * @return
	 */
	@RequestMapping("/fileupload3")						// 注意：MultipartFile对象用于获取解析过的上传文件项，形参的值，必须和form表单中上传文件项的name值相同
	public String fileupload3(MultipartFile upload) throws Exception {
		System.out.println("跨服务器文件上传...");
		// 设置上传到服务器的位置
		String path = "http://localhost:9090/uploads/";

		// 获取上传文件的名称
		String filename = upload.getOriginalFilename();
		// 将文件的名称设置为唯一值，防止覆盖的情况
		String uuid = UUID.randomUUID().toString().replace("-", "");// uuid生成的字符中会有-，我们可以将它替换为空字符串
		filename = uuid + "_" + filename;
		// 将文件上传到服务器
		// 1. 创建客户端对象
		Client client = Client.create();
		// 2. 连接服务器
		WebResource webResource = client.resource(path + filename);
		// 3. 上传文件
		webResource.put(upload.getBytes());
		return "success";
	}
}

package co.fiveglass.notice.product.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.fiveglass.notice.common.Command;
import co.fiveglass.notice.product.service.ProductService;
import co.fiveglass.notice.product.service.ProductVO;
import co.fiveglass.notice.product.serviceImpl.ProductServiceImpl;

public class ProductInsert implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		//실제 insert db작업처리
		ProductService ps = new ProductServiceImpl();
		ProductVO vo = new ProductVO();
		
		String saveDir ="c:/temp/";
		int maxSize = 100 * 1024 * 1024;
		
		try {
			MultipartRequest multi = new MultipartRequest(request, 
														 saveDir, 
														 maxSize, 
														 "utf-8", 
														 new DefaultFileRenamePolicy());
				String pfile = multi.getFilesystemName("pfile");
				pfile = saveDir +pfile;
				String ofile = multi.getOriginalFileName("pfile");
				
				vo.setProductId(multi.getParameter("productId"));
				vo.setProductName(multi.getParameter("productName"));
				
				if(ofile != null) {
					vo.setProductImage(ofile);
					vo.setProductDir(pfile);
				}
				
				ps.productInsert(vo);
				
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return "productList.do";
	}

}

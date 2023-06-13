package co.shop.product.command;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.shop.common.Command;
import co.shop.product.service.ProductService;
import co.shop.product.service.ProductVO;
import co.shop.product.service.Impl.ProductServiceImpl;


public class ProductInsert implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {

		//실제 insert db작업처리
		ProductService ps = new ProductServiceImpl();
		ProductVO vo = new ProductVO();
	      String dir = File.separator + "upload" + File.separator;
	      String saveDir = request.getSession().getServletContext().getRealPath(dir);
		int maxSize = 100 * 1024 * 1024;
		System.out.println("Save Directory: " + saveDir);
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
				vo.setProductKind(multi.getParameter("productKind"));
				vo.setProductPrice(Integer.valueOf(multi.getParameter("productPrice")));
				vo.setProductTaste(multi.getParameter("productTaste"));
				vo.setProductSparkling(multi.getParameter("productSparkling"));
				vo.setProductABV(Integer.valueOf(multi.getParameter("productABV")));
				
				if(ofile != null) {
					vo.setProductImg(ofile);
					vo.setProductImgPath(pfile);
				}
				
				ps.productInsert(vo);
				
		} catch(IOException e) {
			e.printStackTrace();
		}
		return "product.do";


	}

}

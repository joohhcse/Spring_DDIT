package com.spring.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.imgscalr.Scalr;
import org.springframework.web.multipart.MultipartFile;

import com.spring.exception.EmptyMultipartFileException;
import com.spring.exception.OverflowFileSizeException;

public class FileUpload {

	//경로 유동
	public static String uploadFile(MultipartFile multi, String uploadPath)	throws IOException{
		
		//저장 경로..확인 및 생성
		String savePath = calcPath(uploadPath); // uploadpath\년\월\일\
		
		//중복파일명 해결..
		UUID uid = UUID.randomUUID();
		String originalName = multi.getOriginalFilename();
		String saveName=uid.toString().replace("-", "")+"$$"+originalName;
		
		//파일 저장
		File target=new File(savePath,saveName);	
		multi.transferTo(target);
		
		//썸네일 이미지/파일...
		String thumbFileName = null;
		String formatName = originalName.substring(originalName.lastIndexOf(".")+1);
		
		
		if(MediaUtils.getMediaType(formatName)!=null){
			//썸네일 형태로 보여주기
			// file.seperator -> /년/월/일/s_uuid$$originalName.format
			thumbFileName = makeThumbnail(uploadPath,savePath,saveName); 
		}else {
			//텍스트 형태로 보여주기
			// file.seperator -> /년/월/일/uuid$$originalName.format
			thumbFileName = makeIcon(uploadPath,savePath,saveName);
		}
		
		return thumbFileName;		
	} 
	
	//파일 처리 순서
	//1. 경로 설정
	//2. 파일명 정하기 - 중복파일이름 uuid 처리
	//3. 경로 유무 확인 : 생성
	//4. 저장 (이미지 경우  : thumbnail 생성)
	//5. 경로 + 파일명 리턴 (저장) (이미지: thumnuil /tec: source)
	
	
	public static File saveFile(MultipartFile multi, HttpServletRequest request) 
			throws EmptyMultipartFileException, OverflowFileSizeException, IOException
	{
		//유효성 체크때는 else , else if 문이 없다
		if(multi.isEmpty()) {
			throw new EmptyMultipartFileException();
		}
		
		if(multi.getSize() > 1024 * 1024 * 5) {
			throw new OverflowFileSizeException();
		}
		
		String uploadPath = request.getServletContext().getRealPath("resources/upload");
		
		// 파일명 중복 방지
		String fileName = UUID.randomUUID().toString().replace("-", "") + "$$" + multi.getOriginalFilename();
		
		//파일 경로 확인 및 생성
		File file = new File(uploadPath, fileName);
		
		//파일경로생성
		if(!file.exists()) {
			file.mkdirs();
		}
		
		//파일저장
		multi.transferTo(file);
		return file;
	}
	
	public static String calcPath(String uploadPath) throws Exception {
		Calendar cal = Calendar.getInstance();
		
		String yearPath = File.separator + cal.get(Calendar.YEAR);
		String monthPath = yearPath + File.separator + 
				new DecimalFormat("00").format(cal.get(Calendar.MONTH)+1);
		String datePath = monthPath + File.separator +
				new DecimalFormat("00").format(cal.get(Calendar.DATE));
		
		File file = new File(uploadPath + datePath);
		if(!file.exists()) {
			file.mkdirs();
		}
		
		return datePath;
	}
	
	//썸네일 형태
	private static String makeThumbnail(String uploadPath,
										String path, 
										String fileName) throws Exception {
		BufferedImage sourceImg = ImageIO.read(new File(uploadPath + path, fileName));
		
		BufferedImage destImg = Scalr.resize(sourceImg,
								Scalr.Method.AUTOMATIC,
								Scalr.Mode.FIT_TO_HEIGHT, 100);
		
		String thumbnailName = uploadPath+path+File.separator+"s_"+fileName;
		File newFile = new File(thumbnailName);
		String formatName = fileName.substring(fileName.lastIndexOf(".")+1);
		ImageIO.write(destImg, formatName.toUpperCase(),newFile);
		
		return thumbnailName.substring(uploadPath.length()).
				replace(File.separatorChar,'/');
	}

}

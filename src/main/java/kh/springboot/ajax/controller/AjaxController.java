package kh.springboot.ajax.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import kh.springboot.board.model.service.BoardService;
import kh.springboot.board.model.vo.Board;
import kh.springboot.board.model.vo.Reply;
import kh.springboot.member.model.service.MemberService;
import kh.springboot.member.model.vo.Member;
import kh.springboot.member.model.vo.TodoList;
import lombok.RequiredArgsConstructor;

@RestController // @Controller + @ResponseBody
@RequestMapping({"/member", "/board"})
@RequiredArgsConstructor
public class AjaxController {
	private final MemberService mService;
	private final BoardService bService;
	private final JavaMailSender mailSender;
	
	@GetMapping("checkValue")
	public int checkValue(@RequestParam("column") String col, @RequestParam("value") String val) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("col", col);
		map.put("val", val);
		int count = mService.checkValue(map);
		return count;
	}
	
	@GetMapping("echeck")
	public String checkEmail(@RequestParam("email") String email) {
		// SimpleMailMessage : 문자열 형식의 text만 전송 가능
		// MimeMessage : 문자열 형식+html형식 전송 가능
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		
		String subject = "[SpringBoot] 이메일 확인";
		String body = "<h1 align='center'>SpringBoot 이메일 확인</h1><br/>";
		body += "<div style='border: 3px solid skyblue; text-align: center; font-size: 15px;'>";
		body += "본 메일은 이메일을 확인하기 위해 발송되었습니다.<br/>";
		body += "아래 숫자를 인증번호 확인란에 작성하여 확인해주시기 바랍니다.<br/><br/>";
		
		String random ="";
		for(int i = 0; i < 5; i++) {
			random += (int)(Math.random() * 10);
		}
		
		body += "<span style='font-size: 30px; text-decoration: underline;'><b>" + random + "</b></span><br/></div>";
		
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
		try {
			mimeMessageHelper.setTo(email);
			mimeMessageHelper.setSubject(subject);
			mimeMessageHelper.setText(body, true);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		mailSender.send(mimeMessage); // Email 전송
		return random;
	}
	
	@PutMapping("profile")
	public int updateProfile(@RequestParam(value="profile", required=false) MultipartFile profile, Model model) {
		Member m = (Member)model.getAttribute("loginUser");
		
		String savePath = "c:\\profiles";
		File folder = new File(savePath);
		if(!folder.exists()) {
			folder.mkdir();
		}
		
		// 기존 프로필에서 다른 프로필로 변경하는 경우 이전 프로필 사진 지우기
		if(m.getProfile() != null) {
			File f = new File(savePath + "\\" + m.getProfile());
			f.delete();
		}
		
		String renameFileName = null;
		if(profile != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyMMddHHmmssSSS");
			int ranNum = (int)(Math.random()*100000);
			String originFileName = profile.getOriginalFilename();
			renameFileName = sdf.format(new Date()) + ranNum
										+ originFileName.substring(originFileName.lastIndexOf("."));
			
			try {
				profile.transferTo(new File(folder + "\\" + renameFileName));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		m.setProfile(renameFileName);
		int result = mService.updateProfile(m);
		if(result > 0) {
			model.addAttribute("loginUser", m);
		}
		return result;
	}
	
	@PostMapping("list")
	public int insertTodo(@ModelAttribute TodoList tdl) {
		int result = mService.insertTodo(tdl);
		return result > 0 ? tdl.getTodoNum() : result;
	}
	
	@PutMapping("list")
	public int updateTodo(@ModelAttribute TodoList tdl) {
		System.out.println(tdl);
		return mService.updateTodo(tdl);
	}
	
	@DeleteMapping("list")
	public int deleteTodo(@RequestParam("num") int num) {
		return mService.deleteTodo(num);
	}
	
	@GetMapping("top")
    public ArrayList<Board> selectTop() {
    	ArrayList<Board> list = bService.selectTop();
    	return list;
    }
	
	@PostMapping("reply")
    public ArrayList<Reply> insertReply(@ModelAttribute Reply r) {
    	int result = bService.insertReply(r);
    	ArrayList<Reply> list = bService.selectReplyList(r.getRefBoardId());
    	return list;
    }
    
//    @DeleteMapping("reply")
//    public int deleteReply(@RequestParam("rId") int rId) {
//    	return bService.deleteReply(rId);
//    	
//    }
//   
//    @PutMapping("rupdate")
//    public int udateReply(@Model model) {
//    	
//    }
	
	@GetMapping("weather")
	public String getWeather() {
		StringBuilder sb = new StringBuilder();
		try {
			StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst"); /*URL*/
	        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=00656293aba3713243da5226862c9b26b483fe08e8266ab5fc94b7c60851e7cb"); /*Service Key*/
	        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
	        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("1000", "UTF-8")); /*한 페이지 결과 수*/
	        urlBuilder.append("&" + URLEncoder.encode("dataType","UTF-8") + "=" + URLEncoder.encode("JSON", "UTF-8")); /*요청자료형식(XML/JSON) Default: XML*/
	        
	        // 오늘 날씨와 현재 시간 추출 코드
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HHmm");
	        String now = sdf.format(new Date()); // 20260507 1036
	        String[] dayTime = now.split(" ");
	        
	        urlBuilder.append("&" + URLEncoder.encode("base_date","UTF-8") + "=" + URLEncoder.encode(dayTime[0], "UTF-8")); /*‘21년 6월 28일발표*/
	        
	        // 조회 서비스 발표 시각 중 현재 시간과 가장 가까운 시간 선택
	        // 0200, 0500, 0800, 1100, 1400, 1700, 2000, 2300 
	        int[] baseTime = {200, 500, 800, 1100, 1400, 1700, 2000, 2300};
	        int index = 99;
	        for(int i = 0; i < baseTime.length; i++) {
	        	if(Integer.parseInt(dayTime[1]) <= baseTime[i]) {
	        		index = i - 1;
	        		
	        		if(i == 0) {
	        			index = i;
	        		}
	        		dayTime[1] = ("0" + baseTime[index]).substring(("0" + baseTime[index]).length()-4);
	        		break;
	        	}
	        }
	        if(index == 99) {
	        	dayTime[1] = "2300";
	        }
	        
	        urlBuilder.append("&" + URLEncoder.encode("base_time","UTF-8") + "=" + URLEncoder.encode(dayTime[1], "UTF-8")); /*05시 발표*/
	        urlBuilder.append("&" + URLEncoder.encode("nx","UTF-8") + "=" + URLEncoder.encode("60", "UTF-8")); /*예보지점의 X 좌표값*/
	        urlBuilder.append("&" + URLEncoder.encode("ny","UTF-8") + "=" + URLEncoder.encode("127", "UTF-8")); /*예보지점의 Y 좌표값*/
	        
	        //URL url = new URL(urlBuilder.toString());
	        URL url = (new URI(urlBuilder.toString())).toURL();
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Content-type", "application/json");
	        //System.out.println("Response code: " + conn.getResponseCode());
	        BufferedReader rd;
	        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
	            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        } else {
	            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
	        }
	        
	        String line;
	        while ((line = rd.readLine()) != null) {
	            sb.append(line);
	        }
	        rd.close();
	        conn.disconnect();
	        System.out.println(sb.toString());
		} catch(Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

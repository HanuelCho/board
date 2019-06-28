package kh.spring.practice;

import java.io.File;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kh.spring.dao.BoardDAO;
import kh.spring.dao.JoinDAO;
import kh.spring.dao.MessageDAO2;
import kh.spring.dto.BoardDTO;
import kh.spring.dto.JoinDTO;
import kh.spring.dto.MessageDTO;

@Controller
public class HomeController {

	@Autowired
	private HttpSession session;
	@Autowired
	private MessageDAO2 dao;
	@Autowired
	private JoinDAO joindao;
	@Autowired
	private BoardDAO bodao;

	@RequestMapping("/")
	public String index() {
		return "home";
	}

	@RequestMapping("/inputForm")
	public String toInputForm(MessageDTO dto) {

		return "login";
	}

	@RequestMapping("/inputProc")
	public String inputProc(MessageDTO dto) {
		int result = dao.insert(dto);

		return "home";
	}

	@RequestMapping("/outputForm")
	public ModelAndView output() {
		try {
			ModelAndView mav = new ModelAndView();
			mav.addObject("arr", dao.select());
			mav.setViewName("outputForm");
			return mav;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("/joinForm")
	public String joinForm() {
		return "join";
	}

	@RequestMapping("/joinProc")
	public String joinInsert(JoinDTO dto) {
		joindao.insert(dto);
		return "home";
	}

	@RequestMapping("/loginProc")
	public ModelAndView login(JoinDTO dto) throws SQLException {
		ModelAndView mav = new ModelAndView();
		int result = joindao.login(dto);

		if (result == 1) {
			
			JoinDTO jdto=joindao.memberInfo(dto.getId());
			mav.addObject("arr",jdto );
			mav.setViewName("memberlogin");
			session.setAttribute("id", dto.getId());
			return mav;
		} else {
			mav.setViewName("notlogin");
			return mav;
		}
	}

	@ResponseBody
	@RequestMapping("ajax.do")
	public String ajaxProc(String id) {
		String result = Integer.toString(joindao.idcheck(id));

		return result;
	}
//	@RequestMapping("upload.do")
//	public String uploadProc(HttpServletRequest request){
//		System.out.println("업로드");
//		String resourcePath= session.getServletContext().getRealPath("/resources");
//		System.out.println(resourcePath);
//		int maxSize = 10* 1024* 1024;
//		try {
//			MultipartRequest multi= new MultipartRequest(request, resourcePath, maxSize, "utf-8", new DefaultFileRenamePolicy());
//			
//			String name = multi.getParameter("name");
//			File oriFile = multi.getFile("image");
//			System.out.println("이미지  "+name+" : "+oriFile);
//			
//			FileUtils.moveFile(oriFile, new File(resourcePath+"/"+System.currentTimeMillis()+"_id_profile.png"));
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		return"memberlogin";
//	}

	@RequestMapping("upload.do")
	public ModelAndView uploadProc(MultipartFile image) {
		ModelAndView mav = new ModelAndView();

		String path = session.getServletContext().getRealPath("/resources/");
		String subPath = path.substring(95);

		mav.addObject("arr", image);
		mav.setViewName("memberlogin");
		try {
			image.transferTo(new File(path + "image.jpg"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	@RequestMapping("logoutProc")
	public String logout() {
		session.invalidate();
		return "home";
	}
	@RequestMapping("boardForm")
	public String board() {
		
		return "board";
		
	}
	
	@RequestMapping("sendProc")
	public ModelAndView send(BoardDTO dto) {
		ModelAndView mav = new ModelAndView();
		System.out.println("센드프록     "+dto.getTitle()+dto.getContent());
		String seid=(String)session.getAttribute("id");
		dto.setName(seid);
		bodao.insert(dto);
		mav.addObject("member",seid);
		mav.setViewName("home");
		return mav;
	}
	@RequestMapping("listForm")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("list",bodao.list());
		mav.setViewName("boardList");
		return mav;
	}
	@RequestMapping("boardContents")
	public ModelAndView boardContents(int seq) {
		ModelAndView mav = new ModelAndView();
		System.out.println("시퀀시                              "+seq);
		mav.addObject("contents",bodao.contents(seq));
		mav.setViewName("boardContents");
		return mav;
	}
	
}

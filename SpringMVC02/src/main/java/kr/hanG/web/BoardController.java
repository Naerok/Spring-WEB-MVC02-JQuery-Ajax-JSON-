package kr.hanG.web;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.board.domain.Board;
import kr.board.mapper.BoardMapper;

@Controller // POJO
public class BoardController {
	
	@Autowired
	private BoardMapper mapper;
	//HandlerMapping
	
	@RequestMapping("/")
	public String main() {
		return "basic";
	}
	
	
	
	@RequestMapping("/boardList.do")
	public String boardList(HttpServletRequest request ) {
	
		List<Board> list = mapper.boardList();
		request.setAttribute("list", list);
		
		//		 뷰의 논리적인 이름--ViewResolver--> 뷰의 물리적인 이름 (경로)
		return "boardList"; // -> WEB-INF/views/boardList.jsp
	}
	
	@RequestMapping(value="/boardInsert.do", method=RequestMethod.GET)
	public String boardInsertGet() {
		return "boardInsertForm";
	}
	
	//글쓰기 요청 처리
	@RequestMapping(value="boardInsert.do", method=RequestMethod.POST) // form 의 parameter 3개가 넘어옴 (title, contents, writer)
	public String boardInsertPost(Board vo) {
		mapper.boardInsert(vo); // 저장
		
		return "redirect:/boardList.do";
	}
	
	@RequestMapping("/boardContent.do/{idx}")
	public String boardContent(@PathVariable("idx") int idx, Model model) {
		Board vo = mapper.boardContent(idx);
		model.addAttribute("vo", vo);
		return "boardContent";
	}
	
	@RequestMapping("/boardDelete.do")
	public String boardDelete(@RequestParam("idx") int idx) { // 기본적으로  @RequestParam() 가 있는 형태인데 변수가 같다면 자동생략하는것.
		mapper.boardDelete(idx);
		return "redirect:/boardList.do";
	}
	
	@RequestMapping(value="/boardUpdate.do/{idx}", 
					method=RequestMethod.GET)
	public String boardUpdateGet(@PathVariable("idx") int idx, Model model) {
		Board vo=mapper.boardContent(idx);
		model.addAttribute("vo", vo);
		return "boardUpdateForm";
	}
	
	@RequestMapping(value="/boardUpdate.do", 
			method=RequestMethod.POST)
	public String boardUpdatePost(Board vo) {
		mapper.boardUpdate(vo);
		return "redirect:/boardList.do";
	}
	
	@RequestMapping("/boardListAjax.do")
	public @ResponseBody List<Board> boardListAjax() {
		List<Board> list = mapper.boardList();
		//여기서 json data format로 응답.
		// List<Board> --Jackson-->String(JSON)
		return list;
	}
	
	@RequestMapping("boardInsertAjax.do")
	public @ResponseBody void boardInsertAjax(Board vo) {
		mapper.boardInsert(vo);
	}
	
	@RequestMapping("boardContentAjax.do")
	public @ResponseBody void boardContentUpdateAjax(Board vo) {
		mapper.boardContentUpdateAjax(vo);
	}
	
	
}

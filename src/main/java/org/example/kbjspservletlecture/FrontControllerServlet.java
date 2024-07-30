//package org.example.kbjspservletlecture;
//
//import com.example.command.Command;
//import com.example.command.HomeCommand;
//import com.example.command.TodoController;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.RequestDispatcher;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
//@WebServlet(name = "frontControllerServlet", value = "/")
//public class FrontControllerServlet extends HttpServlet {
//
//    // GET 요청을 처리할 명령어 맵
//    private Map<String, Command> getMap;
//    // POST 요청을 처리할 명령어 맵
//    private Map<String, Command> postMap;
//
//    // 컨트롤러 인스턴스 생성
//    private final HomeController homeController = new HomeController();
//    private final TodoController todoController = new TodoController();
//
//    // 서블릿 초기화 메서드
//    @Override
//    public void init() throws ServletException {
//        // 각 URL 경로와 해당하는 명령어 객체를 맵에 등록
//        getMap = new HashMap<>();
//        postMap = new HashMap<>();
//
//        // HomeController 관련 맵핑
//        getMap.put("/", homeController::getIndex);
//
//        // TodoController 관련 맵핑
//        getMap.put("/todo/list", todoController::getList);
//        getMap.put("/todo/view", todoController::getView);
//        getMap.put("/todo/create", todoController::getCreate);
//        getMap.put("/todo/update", todoController::getUpdate);
//
//        postMap.put("/todo/create", todoController::postCreate);
//        postMap.put("/todo/update", todoController::postUpdate);
//        postMap.put("/todo/delete", todoController::postDelete);
//    }
//
//    // GET 요청을 처리하는 메서드
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Command command = getCommand(req);
//        if (command != null) {
//            execute(command, req, resp);
//        } else {
//            resp.sendError(HttpServletResponse.SC_NOT_FOUND); // 404 에러 처리
//        }
//    }
//
//    // POST 요청을 처리하는 메서드
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Command command = getCommand(req);
//        if (command != null) {
//            execute(command, req, resp);
//        } else {
//            resp.sendError(HttpServletResponse.SC_NOT_FOUND); // 404 에러 처리
//        }
//    }
//
//    // 명령어를 실행하고, 결과에 따라 적절한 뷰를 포워드 또는 리다이렉트하는 메서드
//    private void execute(Command command, HttpServletRequest request, HttpServletResponse response)
//            throws IOException, ServletException {
//        String viewName = command.execute(request, response);
//        if (viewName.startsWith("redirect:")) {
//            // 리다이렉트 처리
//            response.sendRedirect(viewName.substring("redirect:".length()));
//        } else {
//            // 포워드 처리
//            String view = PREFIX + viewName + SUFFIX;
//            RequestDispatcher dispatcher = request.getRequestDispatcher(view);
//            dispatcher.forward(request, response);
//        }
//    }
//
//    // 요청 URI에서 명령어 이름을 추출하는 메서드
//    private String getCommandName(HttpServletRequest request) {
//        String requestURI = request.getRequestURI();
//        String contextPath = request.getContextPath();
//        return requestURI.substring(contextPath.length());
//    }
//
//    // 요청에 맞는 명령어 객체를 반환하는 메서드
//    private Command getCommand(HttpServletRequest request) {
//        String commandName = getCommandName(request);
//        if (request.getMethod().equalsIgnoreCase("GET")) {
//            return getMap.get(commandName);
//        } else {
//            return postMap.get(commandName);
//        }
//    }
//}

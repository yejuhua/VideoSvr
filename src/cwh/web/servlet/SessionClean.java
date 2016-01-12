package cwh.web.servlet;

import cwh.utils.log.VSLog;
import cwh.web.servlet.playback.PlaybackHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by cwh on 16-1-7
 */
@WebServlet(name = "SessionClean")
public class SessionClean extends HttpServlet {
    // http://localhost:8888/VideoSvr/SessionClean?sid=12121212
    // return 木有
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VSLog.d("session clean do get");
        VSLog.d(request.getSession().toString());
        request.getSession().invalidate();
        PlaybackHelper.responseString(response, "hello");
        VSLog.d("after invalidate");
    }
}
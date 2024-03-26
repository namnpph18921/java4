package com.example.demo.servlet;

import com.example.demo.Repository.DanhMucRepository;
        import com.example.demo.model.DanhMuc;
        import jakarta.servlet.*;
        import jakarta.servlet.http.*;
        import jakarta.servlet.annotation.*;

        import java.io.IOException;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
        import java.util.List;

@WebServlet(name = "DanhMucServlet", value = {"/DanhMucServlet", "/DanhMucServlet/detail", "/DanhMucServlet/delete", "/DanhMucServlet/update"})
public class DanhMucServlet extends HttpServlet {
    private DanhMucRepository danhMucRepository;
    private List<DanhMuc> danhMucList;
    public DanhMucServlet(){
        danhMucList = new ArrayList<>();
        danhMucRepository = new DanhMucRepository();

        danhMucList = danhMucRepository.getList();
        danhMucList.add(new DanhMuc());
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        switch (uri){
            case "/DanhMucServlet":
                danhMucList = danhMucRepository.getList();
                request.setAttribute("danhMucs", danhMucList);
                request.getRequestDispatcher("/view/danhmuc/danhmuc.jsp").forward(request, response);
                break;
            case "/DanhMucServlet/detail":
                String ma = request.getParameter("code");
                for (int i = 0; i < danhMucList.size(); i++) {
                    if (danhMucList.get(i).getMa().equals(ma)) {
                        System.out.println("found" + " " + ma);
                        request.setAttribute("dm", danhMucList.get(i));
                        System.out.println(danhMucList.get(i).getNgayTao());
                        request.getRequestDispatcher("/view/danhmuc/danhmuc_detail.jsp").forward(request, response);
                    }
                }
                request.setAttribute("dm", danhMucList.get(0));
                request.getRequestDispatcher("/view/danhmuc/danhmuc_detail.jsp").forward(request, response);
                break;
            case "/DanhMucServlet/delete":
                String maXoa = request.getParameter("code");
                danhMucRepository.delete(maXoa);
                response.sendRedirect("/DanhMucServlet");
                break;
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        String maMoi = request.getParameter("maMoi");
        String ten = request.getParameter("ten");
        String trangThai = request.getParameter("trangThai");
        LocalDateTime ngayTao = LocalDateTime.parse(request.getParameter("ngayTao"));
        LocalDateTime ngaySua = LocalDateTime.parse(request.getParameter("ngaySua"));
        DanhMuc danhMuc = new DanhMuc(1, maMoi, ten, trangThai, ngayTao, ngaySua);
        for (int i = 0; i < danhMucList.size(); i++) {
            if (danhMucList.get(i).getMa().equals(ma)) {
                danhMucRepository.update(ma, danhMuc);
                response.sendRedirect("/DanhMucServlet");
            }
        }
    }
}

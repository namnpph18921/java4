package com.example.demo.Repository;


import com.example.demo.model.DanhMuc;
import com.example.demo.connect.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class DanhMucRepository {
 public ArrayList<DanhMuc> getList(){
     Session session = HibernateUtils.getFACTORY().openSession();

     ArrayList<DanhMuc> listDanhMuc = (ArrayList<DanhMuc>) session.createQuery("FROM DanhMuc").list();
     System.out.println(listDanhMuc.size());
     session.close();
     return listDanhMuc;
 }
    public void update(String ma, DanhMuc newData) {
        Session session = HibernateUtils.getFACTORY().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            // Find the DanhMuc entity by 'ma'
            DanhMuc danhMucToUpdate = (DanhMuc) session.createQuery("FROM DanhMuc WHERE ma = :ma")
                    .setParameter("ma", ma)
                    .uniqueResult();

            if (danhMucToUpdate != null) {
                // Update the properties of the found entity
                danhMucToUpdate.setMa(newData.getMa());
                danhMucToUpdate.setTen(newData.getTen());
                danhMucToUpdate.setTrangThai(newData.getTrangThai());
                danhMucToUpdate.setNgaySua(newData.getNgaySua());
                danhMucToUpdate.setNgayTao(newData.getNgayTao());

                // Save the updated entity
                session.update(danhMucToUpdate);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    public void delete(String ma) {
        Session session = HibernateUtils.getFACTORY().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            // Execute a custom HQL query to delete the entity
            int result = session.createQuery("DELETE FROM DanhMuc WHERE ma = :ma")
                    .setParameter("ma", ma)
                    .executeUpdate();

            if (result > 0) {
                System.out.println("Entity deleted successfully");
            } else {
                System.out.println("No entity found with ma: " + ma);
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


    public  static void main(String[] args) {
 }
}

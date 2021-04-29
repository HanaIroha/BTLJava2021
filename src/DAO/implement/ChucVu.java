package DAO.implement;

import DAO.IChucVu;
import Mapper.ChucVuMapper;
import Model.ChucVuModel;
import java.util.List;

/**
 *
 * @author Iroha
 */
public class ChucVu extends DataSource<ChucVuModel> implements IChucVu{

    @Override
    public String TimTenChucVu(String MaCV) {
        String sql = "Select * from dbo.ChucVu WHERE MaCV = ?";
        List<ChucVuModel> result = excute(sql, new ChucVuMapper(), MaCV);
        return result.isEmpty() ? null : result.get(0).getTenCV();
    }

    @Override
    public List<ChucVuModel> getChucVu() {
        String sql = "Select * from dbo.ChucVu";
        return excute(sql, new ChucVuMapper());
    }

    @Override
    public boolean xoaCV(String MaCV) {
        String sql = "Delete from dbo.ChucVu WHERE MaCV = ?";
        return update(sql, MaCV);
    }

    @Override
    public boolean suaCV(String maCV, String tenCV, double phuCap, double LuongCoBan) {
        String sql = "Update dbo.ChucVu SET TenCV = ?, PhuCap=?, LuongCoBan =? WHERE MaCV=?";
        return update(sql, tenCV, phuCap, LuongCoBan, maCV);
    }

    @Override
    public boolean themCV(String maCV, String tenCV, double phuCap, double LuongCoBan) {
        String sql = "Insert into dbo.ChucVu VALUES (?,?,?,?)";
        return update(sql, maCV, tenCV, phuCap, LuongCoBan);
    }
    
}

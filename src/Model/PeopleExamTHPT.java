package Model;

import java.sql.Date;

public class PeopleExamTHPT {
	int id; 
	String mHoten; 
	String mGioitinh; 
	String mNgaysinh; 
	String mDiachi; 
	int mKhuvuc; 
	String mDoituong; 
	String mTruong; 
	String mKhoithi; 
	float mDiemtong;
	public PeopleExamTHPT(int id, String mHoten, String mGioitinh, String mNgaysinh, String mDiachi, int mKhuvuc,
			String mDoituong, String mTruong, String mKhoithi, float mDiemtong) {
		super();
		this.id = id;
		this.mHoten = mHoten;
		this.mGioitinh = mGioitinh;
		this.mNgaysinh = mNgaysinh;
		this.mDiachi = mDiachi;
		this.mKhuvuc = mKhuvuc;
		this.mDoituong = mDoituong;
		this.mTruong = mTruong;
		this.mKhoithi = mKhoithi;
		this.mDiemtong = mDiemtong;
	}
	public PeopleExamTHPT(String mHoten, String mGioitinh, String mNgaysinh, String mDiachi, int mKhuvuc, String mDoituong,
			String mTruong, String mKhoithi, float mDiemtong) {
		super();
		this.mHoten = mHoten;
		this.mGioitinh = mGioitinh;
		this.mNgaysinh = mNgaysinh;
		this.mDiachi = mDiachi;
		this.mKhuvuc = mKhuvuc;
		this.mDoituong = mDoituong;
		this.mTruong = mTruong;
		this.mKhoithi = mKhoithi;
		this.mDiemtong = mDiemtong;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getmHoten() {
		return mHoten;
	}
	public void setmHoten(String mHoten) {
		this.mHoten = mHoten;
	}
	public String getmGioitinh() {
		return mGioitinh;
	}
	public void setmGioitinh(String mGioitinh) {
		this.mGioitinh = mGioitinh;
	}
	public String getmNgaysinh() {
		return mNgaysinh;
	}
	public void setmNgaysinh(String mNgaysinh) {
		this.mNgaysinh = mNgaysinh;
	}
	public String getmDiachi() {
		return mDiachi;
	}
	public void setmDiachi(String mDiachi) {
		this.mDiachi = mDiachi;
	}
	public int getmKhuvuc() {
		return mKhuvuc;
	}
	public void setmKhuvuc(int mKhuvuc) {
		this.mKhuvuc = mKhuvuc;
	}
	public String getmDoituong() {
		return mDoituong;
	}
	public void setmDoituong(String mDoituong) {
		this.mDoituong = mDoituong;
	}
	public String getmTruong() {
		return mTruong;
	}
	public void setmTruong(String mTruong) {
		this.mTruong = mTruong;
	}
	public String getmKhoithi() {
		return mKhoithi;
	}
	public void setmKhoithi(String mKhoithi) {
		this.mKhoithi = mKhoithi;
	}
	public float getmDiemtong() {
		return mDiemtong;
	}
	public void setmDiemtong(float mDiemtong) {
		this.mDiemtong = mDiemtong;
	}
	
	
}

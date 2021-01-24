import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import com.mysql.cj.x.protobuf.MysqlxCrud.Delete;
import Dao.PeopleExamDao;
import Model.PeopleExamTHPT;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;

public class ManagementExam extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTimkiem;
	private JTable table;
	private JScrollPane scrollableTextArea ;
	private JTextField txtID;
	private JTextField txtHo;
	private JTextField txtTimKiem; 
	private JComboBox<Object> cbGT;
	private JComboBox<Object> cbDoituong;
	private JComboBox<Object> cbNgay; 
	private JButton btnTimkiem; 
	private JComboBox<Object> cbThang; 
	private JComboBox<Object> cbNam; 
	private JComboBox<Object> cbKV;  
	private JButton btnThem;
	private JButton btnSua; 
	private JButton btnXoa; 
	private JComboBox<Object> cbOptionSort; 
	private  DefaultTableModel model; 
	private String optionSort; 
	private String option[] = {
			"Mặc định", 
			"Sắp xếp theo giới tính", 
			"Sắp xếp theo khu vực", 
			"Sắp xếp theo đối tượng", 
			"Sắp xếp theo điểm tổng"
	}; 
	private String ngay[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", 
			"19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"
	}; 
	private String gioitinh[] = {"Nam", "Nữ"}; 
	private String thang[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}; 
	private String nam[] = {"1980","1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990","1991",  "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002"};
	private JTextField txtDiachi;
	private JTextField txtTruong;
	private String khuvuc[] = {"1", "2", "3"}; 
	private String doituong[] = {"Bình thường", "Hộ nghèo", "Cận nghèo", "Thương binh, liệt sĩ", "Con cán bộ cấp cao"};
	private int mId; 
	private String mHoten; 
	private int mNgay;  
	private int mThang;   
	private int mNam;
	private String mDate;
	private String mDiachi; 
	private int mKhuvuc;
	private String mDoituong; 
	private String mTruong; 
	private String mGioitinh; 
	private String mKhoithi; 
	private float mDiemthi; 
	private String khoithi[] = {"Khối A", "Khối B", "Khối C", "Khối D", "Khối G"}; 
	private PeopleExamTHPT peopleExam; 
	private JTextField txtTongdiem;
	private JLabel lblNewLabel_10;
	private JComboBox cbKhoi; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagementExam  frame = new ManagementExam ();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ManagementExam () {
		setTitle("Qu\u1EA3n l\u00ED sinh vi\u00EAn thi t\u1ED1t nghi\u1EC7p THPT");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1400, 750);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Ph\u1EA7n m\u1EC1m qu\u1EA3n l\u00ED thi t\u1ED1t nghi\u1EC7p THPT  ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		JLabel lblNewLabel_1 = new JLabel("");
		
		txtTimkiem = new JTextField();
		txtTimkiem.setColumns(10);
		btnTimkiem = new JButton("T\u00ECm ki\u1EBFm ");
		btnTimkiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String timkiem = txtTimkiem.getText(); 
				funTimKiem(timkiem); 
			}

			
		});
		String col[] = {"ID", "Họ Tên", "Giới Tính", "Ngày sinh ", "Địa chỉ", "Khu vực", "Đối tượng", "Trường", "Khối thi", "Tổng điểm"};
		String data[][] = {};
		model = new DefaultTableModel(data,col);
		table = new JTable(model);
		/*
		 * table.getSelectionModel().addListSelectionListener(new
		 * ListSelectionListener() {
		 * 
		 * @Override public void valueChanged(ListSelectionEvent e) {
		 * getDataFromTable(); setValue(); System.out.println("selected"); }
		 * 
		 * });
		 */
		table.addMouseListener((MouseListener) new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				getDataFromTable();
				System.out.println("selected"); 
				
				
			}
		});
		scrollableTextArea = new JScrollPane(table);
		scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
	    scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
		
		JLabel lblNewLabel_2 = new JLabel("ID");
		
		txtID = new JTextField();
		txtID.setEditable(false);
		txtID.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("H\u1ECD t\u00EAn ");
		
		JLabel lblNewLabel_4 = new JLabel("Ng\u00E0y sinh");
		
		cbNgay = new JComboBox<Object>(ngay);
		
		cbThang = new JComboBox<Object>(thang);
		 
		
		cbNam = new JComboBox<Object>(nam);
		
		JLabel lblNewLabel_5 = new JLabel("\u0110\u1ECBa ch\u1EC9");
		
		JLabel lblNewLabel_6 = new JLabel("\u0110\u1ED1i t\u01B0\u1EE3ng ");
		
		cbDoituong = new JComboBox<Object>(doituong);
		
		JLabel lblNewLabel_7 = new JLabel("Khu v\u1EF1c ");
		
		cbKV = new JComboBox<Object>(khuvuc);
		
		JLabel lblNewLabel_9 = new JLabel("Ch\u1ECDn kh\u1ED1i thi");
		
		btnThem = new JButton("Th\u00EAm ");
		btnThem.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
			   try {
				insertData();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}  
		});  
		btnSua = new JButton("S\u1EEDa ");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
			}
		});
		
		txtHo = new JTextField();
		txtHo.setColumns(10);
		
		btnXoa = new JButton("X\u00F3a ");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete(); 
			}
		});
		
		JLabel lblNewLabel_11 = new JLabel("Tr\u01B0\u1EDDng ");
		
		JLabel lblNewLabel_12 = new JLabel("Gi\u1EDBi T\u00EDnh ");
		
		cbGT = new JComboBox<Object>(gioitinh);
		
		txtDiachi = new JTextField();
		txtDiachi.setColumns(10);
		
		txtTruong = new JTextField();
		txtTruong.setColumns(10);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearData();
			}
		});
		
		cbOptionSort = new JComboBox<Object>(option);
		cbOptionSort.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				sort();
			}
		});
		
		cbKhoi = new JComboBox(khoithi);
		
		JLabel lblNewLabel_8 = new JLabel("T\u1ED5ng \u0111i\u1EC3m ");
		
		txtTongdiem = new JTextField();
		txtTongdiem.setColumns(10);
		
		lblNewLabel_10 = new JLabel("Th\u00F4ng tin th\u00ED sinh ");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_10.setForeground(new Color(0, 0, 128));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(380)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(41)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(467)
									.addComponent(txtTimkiem, GroupLayout.PREFERRED_SIZE, 535, GroupLayout.PREFERRED_SIZE)
									.addGap(32)
									.addComponent(btnTimkiem)
									.addGap(18)
									.addComponent(cbOptionSort, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(1)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane.createSequentialGroup()
													.addComponent(lblNewLabel_11)
													.addPreferredGap(ComponentPlacement.UNRELATED)
													.addComponent(txtTruong))
												.addGroup(gl_contentPane.createSequentialGroup()
													.addComponent(lblNewLabel_7)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(cbKV, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
													.addGap(18)
													.addComponent(lblNewLabel_6)
													.addGap(7)
													.addComponent(cbDoituong, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
													.addGap(10))
												.addGroup(gl_contentPane.createSequentialGroup()
													.addComponent(lblNewLabel_5)
													.addGap(32)
													.addComponent(txtDiachi, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_contentPane.createSequentialGroup()
													.addComponent(lblNewLabel_4)
													.addGap(18)
													.addComponent(cbNgay, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
													.addComponent(cbThang, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
													.addGap(18)
													.addComponent(cbNam, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_contentPane.createSequentialGroup()
													.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
														.addGroup(gl_contentPane.createSequentialGroup()
															.addComponent(lblNewLabel_3)
															.addGap(18))
														.addGroup(gl_contentPane.createSequentialGroup()
															.addComponent(lblNewLabel_12)
															.addGap(10))
														.addGroup(gl_contentPane.createSequentialGroup()
															.addComponent(lblNewLabel_2)
															.addGap(42)))
													.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addComponent(txtID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(cbGT, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
														.addComponent(txtHo, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE)))
												.addGroup(gl_contentPane.createSequentialGroup()
													.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addComponent(btnThem)
														.addComponent(lblNewLabel_9)
														.addComponent(lblNewLabel_8))
													.addGap(32)
													.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addComponent(txtTongdiem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addGroup(gl_contentPane.createSequentialGroup()
															.addComponent(btnSua)
															.addGap(30)
															.addComponent(btnXoa)
															.addGap(18)
															.addComponent(btnClear))
														.addComponent(cbKhoi, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)))))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(84)
											.addComponent(lblNewLabel_10)))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(scrollableTextArea, GroupLayout.PREFERRED_SIZE, 948, GroupLayout.PREFERRED_SIZE)))))
					.addGap(32))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtTimkiem, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnTimkiem, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbOptionSort, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_10)
							.addGap(70)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(txtID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtHo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_3))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_12)
								.addComponent(cbGT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_4)
								.addComponent(cbNgay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(cbNam, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(cbThang, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtDiachi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_5))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_7)
								.addComponent(cbKV, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_6)
								.addComponent(cbDoituong, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_11)
								.addComponent(txtTruong, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(cbKhoi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_9))
							.addGap(17)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_8)
								.addComponent(txtTongdiem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(42)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnThem)
								.addComponent(btnSua)
								.addComponent(btnXoa)
								.addComponent(btnClear)))
						.addComponent(scrollableTextArea, GroupLayout.PREFERRED_SIZE, 525, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(52, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		showData();
		}
	@SuppressWarnings("unused")
	private void showData() {
		optionSort = (String) cbOptionSort.getItemAt(cbOptionSort.getSelectedIndex()); 
		List<PeopleExamTHPT> listPeopleExamDaos = PeopleExamDao.getData(optionSort); 
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Object[] rowObjects = new Object[17];
		for(int i = 0; i < listPeopleExamDaos.size(); i++) {
			rowObjects[0] = listPeopleExamDaos.get(i).getId(); 
			rowObjects[1] = listPeopleExamDaos.get(i).getmHoten(); 
			rowObjects[2] = listPeopleExamDaos.get(i).getmGioitinh();
			rowObjects[3] = listPeopleExamDaos.get(i).getmNgaysinh(); 
			rowObjects[4] = listPeopleExamDaos.get(i).getmDiachi(); 
			rowObjects[5] = listPeopleExamDaos.get(i).getmKhuvuc();
			rowObjects[6] = listPeopleExamDaos.get(i).getmDoituong();
			rowObjects[7] = listPeopleExamDaos.get(i).getmTruong();  
			rowObjects[8] = listPeopleExamDaos.get(i).getmKhoithi(); 
			rowObjects[9] = listPeopleExamDaos.get(i).getmDiemtong(); 
			model.addRow(rowObjects);
		}
	}
	private void insertData() throws ParseException {
		getValueTxt();
		if (!mHoten.equals("") ) {
			int isInsertData = PeopleExamDao.insertData(peopleExam);
			if(isInsertData >0) {
				 JOptionPane.showMessageDialog(null,"Thêm dữ liệu thành công!");  
			}
			else {
				 JOptionPane.showMessageDialog(null,"Lỗi!");  
				
			}
		}
		else {
			JOptionPane.showMessageDialog(null,"Thêm các trường đầy đủ!");  
		}
		DefaultTableModel model = (DefaultTableModel) table.getModel(); 
		refeshTable(model);
		 
	}
	private void getValueTxt() {
		mHoten = txtHo.getText(); 
		mDate = cbNgay.getItemAt(cbNgay.getSelectedIndex())+"-" +cbThang.getItemAt(cbThang.getSelectedIndex()) +"-" +cbNam.getItemAt(cbNam.getSelectedIndex());
		mDiachi = txtDiachi.getText(); 
		mKhuvuc = Integer.parseInt((String)cbKV.getItemAt(cbKV.getSelectedIndex()));
		mDoituong = (String) cbDoituong.getItemAt(cbDoituong.getSelectedIndex()); 
		mTruong = txtTruong.getText(); 
		mGioitinh = (String) cbGT.getItemAt(cbGT.getSelectedIndex()); 
		mKhoithi = (String) cbKhoi.getItemAt(cbKhoi.getSelectedIndex());
		mDiemthi = Float.parseFloat(txtTongdiem.getText()); 
		peopleExam = new PeopleExamTHPT(mHoten, mGioitinh, mDate, mDiachi, mKhuvuc, mDoituong, mTruong, mKhoithi, mDiemthi); 
	}

	
	private void getDataFromTable() {
		System.out.println("hello");
		int index = table.getSelectedRow(); 
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel(); 
		 
		mDate = model.getValueAt(index, 3).toString();
		String[] splits = mDate.split("-");
		txtHo.setText(model.getValueAt(index, 1).toString());
		txtID.setText(model.getValueAt(index, 0).toString());
		txtTruong.setText(model.getValueAt(index, 7).toString());
		txtDiachi.setText(model.getValueAt(index, 4).toString());
		cbGT.setSelectedItem(model.getValueAt(index, 2).toString());
		cbDoituong.setSelectedItem(model.getValueAt(index, 6).toString());
		cbNgay.setSelectedItem(mNgay);
		cbThang.setSelectedItem(mThang);
		cbNam.setSelectedItem(mNam);
		cbKV.setSelectedItem(model.getValueAt(index, 5).toString());
		cbKhoi.setSelectedItem(model.getValueAt(index, 8).toString());
		txtTongdiem.setText(model.getValueAt(index, 9).toString());
	}
	
	private void clearData() {
		txtHo.setText("");
		txtID.setText("");
		txtTruong.setText("");
		txtDiachi.setText("");
		cbGT.setSelectedIndex(0);
		cbDoituong.setSelectedIndex(0);
		cbNgay.setSelectedIndex(0);
		cbThang.setSelectedIndex(0);
		cbNam.setSelectedIndex(0);
		cbKV.setSelectedIndex(0);
		txtTongdiem.setText("");
		cbKhoi.setSelectedIndex(0);
	}
	
	private void delete() {
		mId = Integer.parseInt(txtID.getText()); 
		int result = PeopleExamDao.delete(mId); 
		if (result > 0) {
			JOptionPane.showMessageDialog(null,"Xóa dữ liệu thành công!");  
		}
		else {
			JOptionPane.showMessageDialog(null,"Lỗi!");  
		}
		DefaultTableModel model = (DefaultTableModel) table.getModel(); 
		refeshTable(model);
		 
	}
	private void update() {
		getValueTxt();
		mId = Integer.parseInt(txtID.getText()); 
		peopleExam = new PeopleExamTHPT(mId, mHoten, mGioitinh, mDate, mDiachi, mKhuvuc, mDoituong, mTruong, mKhoithi, mDiemthi) ; 
		int result = PeopleExamDao.update(peopleExam); 
		if (result > 0) {
			JOptionPane.showMessageDialog(null,"Sửa dữ liệu thành công!");  
		}
		else {
			JOptionPane.showMessageDialog(null,"Lỗi!");  
		}
		DefaultTableModel model = (DefaultTableModel) table.getModel(); 
		refeshTable(model);
	}
	private void refeshTable(DefaultTableModel model) {
		clearData();
		model.setRowCount(0);
		showData();
	}
	private void funTimKiem(String timkiem) {
		optionSort = (String) cbOptionSort.getItemAt(cbOptionSort.getSelectedIndex()); 
		List<PeopleExamTHPT> listPeopleExamDaos = PeopleExamDao.getData(optionSort); 
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		Object[] rowObjects = new Object[17];
		for(int i = 0; i < listPeopleExamDaos.size(); i++) {
			rowObjects[0] = listPeopleExamDaos.get(i).getId(); 
			rowObjects[1] = listPeopleExamDaos.get(i).getmHoten(); 
			rowObjects[3] = listPeopleExamDaos.get(i).getmGioitinh();
			rowObjects[4] = listPeopleExamDaos.get(i).getmNgaysinh(); 
			rowObjects[5] = listPeopleExamDaos.get(i).getmDiachi(); 
			rowObjects[6] = listPeopleExamDaos.get(i).getmKhuvuc();
			rowObjects[7] = listPeopleExamDaos.get(i).getmDoituong();
			rowObjects[8] = listPeopleExamDaos.get(i).getmTruong();  
			rowObjects[9] = listPeopleExamDaos.get(i).getmKhoithi(); 
			rowObjects[9] = listPeopleExamDaos.get(i).getmDiemtong(); 
			if (listPeopleExamDaos.get(i).getmHoten().contains(timkiem) 
					|| listPeopleExamDaos.get(i).getmDiachi().contains(timkiem) || listPeopleExamDaos.get(i).getmTruong().contains(timkiem)
					|| listPeopleExamDaos.get(i).getmGioitinh().contains(timkiem)) {
				model.addRow(rowObjects);
			}
			
		}
		
	}
	private void sort() {
		DefaultTableModel model = (DefaultTableModel) table.getModel(); 
		refeshTable(model);
	}
}

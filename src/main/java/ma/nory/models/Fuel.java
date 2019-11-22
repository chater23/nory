package ma.nory.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Fuel")
public class Fuel implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, unique = true, nullable = false)
	private Integer id;

	@Column(name = "cardNumber", updatable = true, unique = false, nullable = true)
	private Integer cardNumber;

	@Column(name = "reportNumber", updatable = true, unique = false, nullable = true)
	private Integer reportNumber;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_", updatable = true, unique = false, nullable = true)
	private Date date_;

	@Column(name = "serial", updatable = true, unique = false, nullable = true, length = 20)
	private String serial;

	@Column(name = "km", updatable = true, unique = false, nullable = true)
	private Float km;

	@Column(name = "liter", updatable = true, unique = false, nullable = true)
	private Float liter;

	@Column(name = "amount", updatable = true, unique = false, nullable = true)
	private BigDecimal amount;

	@Column(name = "mntLiter", updatable = true, unique = false, nullable = true)
	private Float mntLiter;

	@Column(name = "FRS", updatable = true, unique = false, nullable = true, length = 40)
	private String frs;

	@Column(name = "mounth", updatable = true, unique = false, nullable = true)
	private Integer mounth;

	@Column(name = "number", updatable = true, unique = false, nullable = true)
	private String number;

	@Column(name = "serial22", updatable = true, unique = false, nullable = true, length = 20)
	private String serial22;

	@Column(name = "assignment", updatable = true, unique = false, nullable = true, length = 50)
	private String assignment;

	@Column(name = "sector", updatable = true, unique = false, nullable = true, length = 50)
	private String sector;

	@Column(name = "department", updatable = true, unique = false, nullable = true, length = 50)
	private String department;

	@Column(name = "year", updatable = true, unique = false, nullable = true)
	private Integer year;

	@Column(name = "mounth2", updatable = true, unique = false, nullable = true)
	private Integer mounth2;

	@Column(name = "bill_number", updatable = true, unique = false, nullable = true)
	private Integer bill_number;

	@Temporal(TemporalType.DATE)
	@Column(name = "bill_date", updatable = true, unique = false, nullable = true)
	private Date bill_date;

	@Column(name = "htAmount", updatable = true, unique = false, nullable = true)
	private Float htAmount;

	@Column(name = "tvBill", updatable = true, unique = false, nullable = true)
	private Float tvBill;

	@Column(name = "tvaAccounting", updatable = true, unique = false, nullable = true)
	private Float tvaAccounting;

	@Column(name = "htPorta", updatable = true, unique = false, nullable = true)
	private Float htPorta;

	public Fuel(){}
	
	public Fuel(Integer cardNumber, Integer reportNumber, Date date_,
			String serial, Float km, Float liter, BigDecimal amount,
			Float mntLiter, String frs, Integer mounth, String number,
			String serial22, String assignment, String sector,
			String department, Integer year, Integer mounth2,
			Integer bill_number, Date bill_date, Float htAmount, Float tvBill,
			Float tvaAccounting, Float htPorta) {
		super();
		this.cardNumber = cardNumber;
		this.reportNumber = reportNumber;
		this.date_ = date_;
		this.serial = serial;
		this.km = km;
		this.liter = liter;
		this.amount = amount;
		this.mntLiter = mntLiter;
		this.frs = frs;
		this.mounth = mounth;
		this.number = number;
		this.serial22 = serial22;
		this.assignment = assignment;
		this.sector = sector;
		this.department = department;
		this.year = year;
		this.mounth2 = mounth2;
		this.bill_number = bill_number;
		this.bill_date = bill_date;
		this.htAmount = htAmount;
		this.tvBill = tvBill;
		this.tvaAccounting = tvaAccounting;
		this.htPorta = htPorta;
	}

	public Integer getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(Integer cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Integer getReportNumber() {
		return reportNumber;
	}

	public void setReportNumber(Integer reportNumber) {
		this.reportNumber = reportNumber;
	}

	public Date getDate_() {
		return date_;
	}

	public void setDate_(Date date_) {
		this.date_ = date_;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public Float getKm() {
		return km;
	}

	public void setKm(Float km) {
		this.km = km;
	}

	public Float getLiter() {
		return liter;
	}

	public void setLiter(Float liter) {
		this.liter = liter;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Float getMntLiter() {
		return mntLiter;
	}

	public void setMntLiter(Float mntLiter) {
		this.mntLiter = mntLiter;
	}

	public String getFrs() {
		return frs;
	}

	public void setFrs(String frs) {
		this.frs = frs;
	}

	public Integer getMounth() {
		return mounth;
	}

	public void setMounth(Integer mounth) {
		this.mounth = mounth;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getSerial22() {
		return serial22;
	}

	public void setSerial22(String serial22) {
		this.serial22 = serial22;
	}

	public String getAssignment() {
		return assignment;
	}

	public void setAssignment(String assignment) {
		this.assignment = assignment;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getMounth2() {
		return mounth2;
	}

	public void setMounth2(Integer mounth2) {
		this.mounth2 = mounth2;
	}

	public Integer getBill_number() {
		return bill_number;
	}

	public void setBill_number(Integer bill_number) {
		this.bill_number = bill_number;
	}

	public Date getBill_date() {
		return bill_date;
	}

	public void setBill_date(Date bill_date) {
		this.bill_date = bill_date;
	}

	public Float getHtAmount() {
		return htAmount;
	}

	public void setHtAmount(Float htAmount) {
		this.htAmount = htAmount;
	}

	public Float getTvBill() {
		return tvBill;
	}

	public void setTvBill(Float tvBill) {
		this.tvBill = tvBill;
	}

	public Float getTvaAccounting() {
		return tvaAccounting;
	}

	public void setTvaAccounting(Float tvaAccounting) {
		this.tvaAccounting = tvaAccounting;
	}

	public Float getHtPorta() {
		return htPorta;
	}

	public void setHtPorta(Float htPorta) {
		this.htPorta = htPorta;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}

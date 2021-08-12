package kodlamaio.ReCapProject.business.constants;

import kodlamaio.ReCapProject.entities.concretes.Customer;

public abstract class Messages {

	public static String brandAdded = "Brand eklendi";
	public static String photoNumberError = "En fazla 5 fotoğraf eklenebilir";
	public static String photoDeleted = "Fotoğraf silindi";
	public static String photoAdded = "Fotoğraf eklendi";
	public static String carAdded = "Araç eklendi";
	public static String carCouldntAdded = "Araç eklenemedi";
	public static String carDeleted = "Araç silindi";
	public static String colorAdded = "Renk eklendi";
	public static String colorDeleted = "Renk silindi";
	public static String customerAdded = "Müşteri eklendi";
	public static String customerDeleted = "Müşteri silindi";
	public static String rentalAdded = "Rental eklendi";
	public static String emailError = "Girilen mail adresi zaten kullanılıyor";
	public static String nameSurnameError = "İsim veya soyisim sayı karakteri içeremez";
	public static String passwordError = "Şifre en az 6 karakter içermelidir";
	public static String loginSuccess = "Giriş yapıldı";
	public static String loginError = "Giriş yapılamadı";
	public static String messageSubject = "Aktivasyon Kodu";
	public static String mailError = "";
	public static String customerActivated = "Müşteri aktif edildi";
	public static String activationCodeError = "Aktivasyon kodu eşleşmedi";
	public static String emailSent = "Email gönderildi";
	public static String emailValidError = "Lütfen kullandığınız bir email adresi giriniz";

	public static String messageBody(Customer customer, String activationCode) {
		return "Sayın " +customer.getFirstName().substring(0, 1).toUpperCase() + customer.getFirstName().substring(1) + " " + customer.getLastName().toUpperCase()+ " Hoşgeldiniz! \nHesabınızı aktif etmeniz ve araç kiralama imkanı için aktivasyon kodu: \n\n"+activationCode;
	}
	
	public static String activationCodeSent(Customer customer) {
		return "aktivasyon kodu gönderildi: " + customer.getEmail();
	}
	
	
	
	
}

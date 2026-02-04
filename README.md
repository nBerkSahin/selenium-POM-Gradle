GETMOBIL PROJECT (ENGLISH) and (TURKISH)
--------------------------------------

(ENGLISH)
--------
Getmobil.com Purchase Flow Test Automation

This project is a test automation framework developed to validate the purchase flow of Getmobil.com.  
It covers product search, cart operations, and order completion processes using modern QA automation practices.

The framework is built with:

- Java  
- Selenium WebDriver  
- TestNG  
- Gradle  
- Allure Reporting  
- Page Object Model (POM)

Project Goal

The goal of this project is to automate the critical user journey where a customer successfully purchases a product from Getmobil.com.

The automation validates:

- Homepage performance and UI elements  
- Product search functionality  
- Dynamic product validations (price, title)
- Static product validations (price, title)    
- Cart operations (add/remove products)  

Framework Architecture

The project follows the Page Object Model (POM) design pattern to ensure:

- Maintainable code
- High readability
- Reusable components
- Reduced test flakiness


Setup & Installation

(Prerequisites) Make sure you have installed:

- Java 17+
- Gradle
- Chrome Browser
- Allure


Clone the Repository

git clone https://github.com/nBerkSahin/selenium-pom-gradle-project2.git
cd selenium-pom-gradle-project2

Run Tests

./gradlew clean test


Allure Reporting

Generate Report:

allure serve build/allure-results

OR

allure generate build/allure-results --clean
allure open

The report includes:

- Test steps  
- Assertions  
- Failure screenshots  
- Execution details  


Test Scenarios Implemented

Scenario1: Homepage Validation
- Verified that the homepage loads within “3 seconds”
- The number of seconds it takes for DOM and HTML events to occur on the homepage is calculated.
- Checked visibility of dynamic banners and promotional components

Scenario2: Product Search
- Searched for a specific keyword (e.g., “iPhone 14”)
- Validated product titles, prices, and stock information statically

Scenario3:  Cart Operations
- Multiple products with different stock levels are added to the cart.
- The products added to the cart are checked to ensure they are the same as the selected products.
- A product is deleted and its removal from the cart is confirmed.
- It is confirmed that the selected product is the one removed from the cart.

If you have any questions or feedback, feel free to reach out! 


(TÜRKÇE)
------------

Getmobil.com Satın Alma Süreci Test Otomasyonu

Bu proje, Getmobil.com e-ticaret platformunun satın alma sürecinin bir kısmını test etmek amacıyla geliştirilmiş bir test otomasyon framework’üdür.

Proje aşağıdaki teknolojiler kullanılarak geliştirilmiştir:
- Java  
- Selenium WebDriver  
- TestNG  
- Gradle  
- Allure Report  
- Page Object Model (POM)

Projenin Amacı

Bu projenin amacı, bir kullanıcının Getmobil.com üzerinde ürün arama ve sepete ekleme sürecini başarılı şekilde tamamlayabildiğini doğrulamaktır.

Otomasyon kapsamında doğrulanan başlıca akışlar:

- Ana sayfa performansı ve UI kontrolleri  
- Ürün arama fonksiyonu  
- Dinamik ve static ürün doğrulamaları (fiyat, ürün adı)  
- Sepet işlemleri (ürün ekleme / silme)  

Framework Mimarisi

Projede Page Object Model (POM) tasarım deseni kullanılmıştır.

- Daha sürdürülebilir test yapısı
- Okunabilir kod
- Tekrar kullanılabilir metodlar oluşturulması hedeflenmiştir.


Kurulum ve Çalıştırma

Gereksinimler

Aşağıdaki araçların sisteminizde kurulu olması gerekir:

- Java 17+
- Gradle
- Google Chrome
- Allure

Repo Klonlama Prosesi

git clone https://github.com/nBerkSahin/selenium-pom-gradle-project2.git
cd selenium-pom-gradle-project2


Testleri Çalıştırma

./gradlew clean test


Allure Raporu

Raporu Oluşturma ve Açma

allure serve build/allure-results

veya:

allure generate build/allure-results --clean
allure open

Allure raporu içeriğinde;

- Test adımları  
- Assertion sonuçları  
- Hata detayları  
- Test çalıştırma bilgileri bulunmaktadır.

Gerçekleştirilen Test Senaryoları

Scenario1: Ana Sayfa Kontrolleri
- Ana sayfanın 3 saniye içinde yüklendiği doğrulanır
- Ana sayfadaki DOM ve HTML Event ların kaç sn de gerçekleştiği hesaplanır.
- Dinamik banner ve promosyon bileşenlerinin görünürlüğü kontrol edilir

Scenario2: Ürün Arama
- “iPhone 14” gibi anahtar kelimelerle birden fazla ürün girilerek arama yapılır
- Ürün adı ve fiyat bilgileri statik olarak doğrulanır

Scenario3: Sepet İşlemleri
- Farklı stok seviyelerine sahip birden fazla ürün sepete eklenir
- Sepete eklenen ürünlerin seçilen ürünlerle aynı ürünler olduğu kontrol edilir.
- Bir ürün silinir ve sepetten kaldırıldığı doğrulanır
- Seçilen ürünün sepetten kaldırılan ürün olduğu doğrulanır.


Her türlü geri bildirim için benimle iletişime geçebilirsiniz

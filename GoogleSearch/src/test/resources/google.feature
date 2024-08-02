Feature: Googleda arama yapabilirim
  Scenario: Burc Yorumu hakkinda google arama
    Given Google sayfasina git
    When Arama kismina Burc Yorumu yaz ve arama yap
    Then Donen yaniti kontrol et
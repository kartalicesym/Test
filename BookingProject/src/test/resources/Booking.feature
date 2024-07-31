Feature: Kullanici olarak otel rezervasyonu olusturabilirim
  Scenario: Kullanici bir otel rezervasyonu olusturabilir
    Given Kullanici yeni bir rezervasyon olusturuyor
    When Kullanici otel rezervasyonu yaratiyor
    Then Rezervasyon basarili sekilde olusturuldu

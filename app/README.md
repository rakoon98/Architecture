## 그래들 관리
VersionCatalog toml 사용하여 관리

## 멀티 모듈
+ feature(ui-01, ui-02) 의 Ui_01_MainActivity,Ui_02_MainActivity + feature(featurecontroller) 의 deeplink 관련 사항들
  - 멀티 모듈인데 각 feature 를 독립적으로 만든 경우.
  - 각 피쳐가 액티비티로 만들어져있기에 이를 딥링크 시 연결 시키기 위해 DeeplinkHandler, DeeplinkProcessor 로 연결되게 통제한다.
  - 멀티 모듈로 만든 후, 이동할때 feature to feature 시 에 다른 모듈의 액티비티를 모르기 때문에 Intent(context,"com.example.ui_02.Ui_02_MainActivity") 와 같이 경로를 입력하여 설정. 

+ 전체 컴포즈로 만들어 져 있고, 전체 SPA 로 구성하게 되는 경우 (구글 권고)
  - 해당 피쳐에 만든 그래프만 컨트롤러에서 가져가게 설정하고, 딥링크 사용 시 별도 설정(handler,processor) 하지 않고 URI 만 잘 설정해서 사용 가능
  - +) manifest(app) scheme, host 설정은 해야 함.

## 컴포즈 
+ 앱상태 관리(AppState)
  - @Stable 어노테이션을 사용하여 구성된 appState 클래스를 통해 앱의 전반적인 움직임이나 컨트롤을 담당하는 클래스를 생성.
  - scaffoldState, snackbarMessage, navController, shouldShowBottomBar 등 여러 컨트롤을 담당시킨다.
  - 해당 클래스는 @Composable 에서 remember 로 기억하게 만들고 메인의 setContent {} 레벨 수준 에서 선언하여 앱전체가 알 수 있도록 라이프 사이클을 맨위로 두어서 사용한다.

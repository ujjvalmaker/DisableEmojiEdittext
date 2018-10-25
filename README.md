# Disable Emoji Edittext
![collage](https://user-images.githubusercontent.com/44433243/47475209-2e382600-d838-11e8-870e-fe491e68ef57.jpg)

Set Charset , Disable Emoji and Android system other character. Set First Character is Capital or not , Set Drawable shape in edittext.

Add it in your root build.gradle at the end of repositories:
```
allprojects {
   repositories {
		    ...
		    maven { url 'https://jitpack.io' }
		}
	}
    
 Add the dependency
     
dependencies {
	        implementation 'com.github.ujjvalmaker:DisableEmojiEdittext:0.1.0'
	}
 ```   


Apply Custom Font From Assets folder
```xml

    <com.alastrine.edittextemoji.EdtxtEmoji
            android:layout_marginTop="20dp"
            android:paddingLeft="20dp"
            android:id="@+id/edtxt_custom2"
            app:font_style="Aquino-Demo.ttf"    // Custom Font Apply
            android:hint=" Only Digit"
            android:layout_width="match_parent"
            android:layout_height="wrap_content" />

```

            
```java            
        Set First Character is Capital
        edtxtEmoji.firstCharCapital(true);

        Set Shape Background
        edtxtEmoji.shapeBackground(R.drawable.edittext_shape);

        // TODO Set Allow Cahracter in Edittext , Disable emoji and other character 
        // Here pass Type of Pattern 
        0 - [a-zA-Z]
        1 - [a-zA-Z0-9]
        2 - [0-9]
        edtxtEmoji.setAllowChar(0);  
                                  
```

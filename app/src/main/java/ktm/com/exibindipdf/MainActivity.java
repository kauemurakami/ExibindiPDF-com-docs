package ktm.com.exibindipdf;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WebView webView = new WebView(MainActivity.this);
        webView.getSettings().setJavaScriptEnabled(true);

        /*Necessário sobescrever o método shouldOverrideUrlLoading retornando false
         * pois por padrão o WebView irá passar para o Activity Manager escolher qual
         * a melhor opção para abrir a URL, dessa forma o próprio WebView irá abrir a URL */
        webView.setWebViewClient(new Callback());

        /*Coloque aqui o LINK para o PDF, mantido um link apenas para teste*/
        String pdfURL = "http://static.googleusercontent.com/media/research.google.com/pt-BR//pubs/archive/38356.pdf";

        /*Carrega a URL utilizando visualizador do Google Docs */
        webView.loadUrl(
                "http://docs.google.com/gview?embedded=true&url=" + pdfURL);

        setContentView(webView);

    }

    private class Callback extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(
                WebView view, String url) {
            return (false);
        }
    }
}
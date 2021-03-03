package dev.kevinlucas.canalvinciusthiengo.ui

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.kevinlucas.canalvinciusthiengo.R
import dev.kevinlucas.canalvinciusthiengo.config.YouTubeConfig
import dev.kevinlucas.canalvinciusthiengo.data.fixed.MenuItemsData
import dev.kevinlucas.canalvinciusthiengo.ui.adapter.MenuAdapter
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Atividade principal e única atividade do
 * aplicativo.
 *
 * @constructor cria um objeto completo do tipo
 * [MainActivity].
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        /**
         * Devido ao uso de uma Splash Screen
         * personalizada.
         */
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initBottomMenu()
    }

    /**
     * Invoca o aplicativo do YouTube para que o usuário
     * tenha acesso direto ao canal.
     *
     * Esse listener de clique está vinculado aos
     * componentes visuais do topo do aplicativo.
     *
     * Caso o aplicativo nativo do YouTube e nem mesmo um
     * navegador Web esteja instalado no aparelho (algo
     * utópico), então uma mensagem de falha é apresentada
     * ao usuário.
     *
     * @param view componente visual que teve o evento de
     * toque (clique) disparado.
     */
    fun openYouTubeChannel(view: View) {
        val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse(YouTubeConfig.Channel.CHANNEL_URL)
        )

        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Toast
                    .makeText(
                            this,
                            getString(R.string.channel_toast_alert),
                            Toast.LENGTH_LONG
                    )
                    .show()
        }

    }

    /**
     * Inicializa o menu principal do aplicativo, o
     * BottomMenu.
     */
    private fun initBottomMenu() {
        val layoutManager = GridLayoutManager(
                this,
                MenuAdapter.NUMBER_COLUMNS,
                RecyclerView.HORIZONTAL,
                false
        )

        rv_menu.layoutManager = layoutManager

        rv_menu.setHasFixedSize(true)
        rv_menu.adapter = MenuAdapter(
                context = this,
                items = MenuItemsData.getItems(res = resources),
                changeFragmentCallback = { item ->
                    { /* TODO */ }
                }
        )
    }
}
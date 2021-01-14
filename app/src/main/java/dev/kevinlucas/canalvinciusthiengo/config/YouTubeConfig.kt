package dev.kevinlucas.canalvinciusthiengo.config

class YouTubeConfig {

    abstract class Channel {
        companion object {
            /**
             * Constante com o identificador único do
             * canal. Com esse ID é possível
             * carregar da YouTube Data API os dados do
             * canal correto.
             */

            const val CHANNEL_ID = "UCG3gFuIkRF3PpNkRk3Wp6dw"

            /**
             * Constante com a URL do canal.
             */
            const val CHANNEL_URL = "https://www.youtube.com/channel/$CHANNEL_ID"

        }
    }

}
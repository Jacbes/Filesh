package dev.jacbes.filesh

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.add
import androidx.fragment.app.commit
import dev.jacbes.filesh.ui.sendtab.SendFragment

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<DockFragment>(R.id.fragment_container_view)
                add<SendFragment>(R.id.fragment_base, "SEND_FRAGMENT")
            }
        }
    }
}
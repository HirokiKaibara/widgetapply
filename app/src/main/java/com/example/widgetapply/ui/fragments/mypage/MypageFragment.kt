package com.example.widgetapply.ui.fragments.mypage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.example.widgetapply.R
import com.example.widgetapply.ui.fragments.mypage.history.DownloadHistoryFragment
import com.example.widgetapply.ui.fragments.mypage.payment.PaymentInfoFragment
import com.example.widgetapply.ui.fragments.mypage.account.AccountFragment
import com.example.widgetapply.ui.fragments.mypage.fanlink.FanlinkFragment
import com.example.widgetapply.ui.fragments.mypage.tab.TabHistoryFragment
import com.example.widgetapply.ui.fragments.mypage.notification.NotificationFragment
import com.example.widgetapply.ui.fragments.mypage.help.HelpFragment
import com.example.widgetapply.ui.fragments.mypage.contact.ContactFragment

class MypageFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_mypage, container, false)
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        // ダウンロード履歴への遷移
        view.findViewById<LinearLayout>(R.id.downloadHistoryLayout).setOnClickListener {
            navigateToDownloadHistory()
        }
        
        // アカウント設定への遷移
        view.findViewById<LinearLayout>(R.id.accountLayout).setOnClickListener {
            navigateToAccount()
        }
        
        // Fanlink（連携）への遷移
        view.findViewById<LinearLayout>(R.id.fanlinkLayout).setOnClickListener {
            navigateToFanlink()
        }
        
        // 決済情報への遷移
        view.findViewById<LinearLayout>(R.id.paymentLayout).setOnClickListener {
            navigateToPaymentInfo()
        }
        
        // 通知画面への遷移
        view.findViewById<LinearLayout>(R.id.notificationLayout).setOnClickListener {
            navigateToNotification()
        }
        
        // ヘルプページへの遷移
        view.findViewById<LinearLayout>(R.id.helpLayout).setOnClickListener {
            navigateToHelp()
        }
        
        // お問い合わせページへの遷移
        view.findViewById<LinearLayout>(R.id.contactLayout).setOnClickListener {
            navigateToContact()
        }
    }
    
    private fun navigateToDownloadHistory() {
        val fragment = DownloadHistoryFragment()
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.mainContainer, fragment)
            .addToBackStack("downloadHistory")
            .commit()
    }
    
    private fun navigateToAccount() {
        val fragment = AccountFragment()
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.mainContainer, fragment)
            .addToBackStack("account")
            .commit()
    }
    
    private fun navigateToFanlink() {
        val fragment = FanlinkFragment()
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.mainContainer, fragment)
            .addToBackStack("fanlink")
            .commit()
    }
    
    private fun navigateToPaymentInfo() {
        val fragment = PaymentInfoFragment()
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.mainContainer, fragment)
            .addToBackStack("payment")
            .commit()
    }
    
    private fun navigateToNotification() {
        val fragment = NotificationFragment()
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.mainContainer, fragment)
            .addToBackStack("notification")
            .commit()
    }
    
    private fun navigateToHelp() {
        val fragment = HelpFragment()
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.mainContainer, fragment)
            .addToBackStack("help")
            .commit()
    }
    
    private fun navigateToContact() {
        val fragment = ContactFragment()
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.mainContainer, fragment)
            .addToBackStack("contact")
            .commit()
    }
}

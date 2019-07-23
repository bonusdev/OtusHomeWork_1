package com.bonusgaming.homework_1

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer

private const val TAG_ITEM_FRAGMENT = "ItemFragment"
private const val TAG_LIST_FRAGMENT = "ListFragment"
private const val BACK_STACK = "BackStack"


/* Основное View*/
class MainActivity : Contract.BaseActivityView() {

    private fun showItemFragment() {
        val res = supportFragmentManager.beginTransaction()
            .hide(supportFragmentManager.getListFragment())
            .show(supportFragmentManager.getItemFragment())
            .addToBackStack(BACK_STACK)
            .commit()
        (supportFragmentManager.getItemFragment() as ItemFragment).invalidateItem()
    }

    private fun FragmentManager.getListFragment(): Fragment {
        return generateSomeFragment(TAG_LIST_FRAGMENT)
    }

    private fun FragmentManager.getItemFragment(): Fragment {
        return generateSomeFragment(TAG_ITEM_FRAGMENT)
    }

    private fun FragmentManager.generateSomeFragment(tag: String): Fragment {
        var fragment = this.findFragmentByTag(tag)
        if (fragment == null) {
            fragment = when (tag) {
                TAG_ITEM_FRAGMENT -> ItemFragment()
                else -> ListFragment()
            }
            beginTransaction().add(R.id.frame_main, fragment, tag).commitNow()
        }
        return fragment
    }

    override fun initViews() {
        setContentView(R.layout.acivity_main)
    }

    override fun init() {
        supportFragmentManager.getListFragment()

        val listImpl = App.appComponent.getListImpl()

        viewModel.getOnClickLiveData().observe(this, Observer {
            showItemFragment()
        })
        viewModel.getListItemsLiveData().observe(this, Observer {
            listImpl.addItems(it)
        })

    }
}
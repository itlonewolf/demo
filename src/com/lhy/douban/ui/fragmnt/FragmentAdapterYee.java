package com.lhy.douban.ui.fragmnt;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * 所有vp的adapter类
 * 
 * @author yangxiaoyi
 * 
 */
public class FragmentAdapterYee extends FragmentPagerAdapter {
	/**
	 * 用来记录getCount的个数
	 */
	private final AllFragmnt which;

	public FragmentAdapterYee(FragmentManager fm,
			AllFragmnt which) {
		super(fm);
		this.which = which;

		switch (this.which) {
		case CINEMA:
			// TODO

			break;
		case MOVIE:
			// TODO
			break;
		case CELEBRITY:
			// TODO
			break;
		default:
			throw new RuntimeException("出错了，枚举中没有此项...");
		}
	}

	@Override
	public Fragment getItem(int position) {
		switch (which) {
		case CINEMA:
			switch (position) {
			case 0:
				return new Showing();
			case 1:
				return new Cinema();
			case 2:
				return new Collect();
			}
		case MOVIE:
			// TODO
		case CELEBRITY:
			// TODO

		default:
			break;
		}
		return null;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		switch (this.which) {
		case CINEMA://
			switch (position) {
			case 0:
				return "上映";
			case 1:
				return "影院";
			case 2:
				return "我看";
			default:
				throw new RuntimeException("第一层怎么能有第四个标题呢。。。");
			}
		case MOVIE:
			switch (position) {
			case 0:
				return "介绍";
			case 1:
				return "图片";
			case 2:
				return "短评";
			case 3:
				return "影评";
			default:
				throw new RuntimeException("第一层怎么能有第5个标题呢。。。");
			}
		case CELEBRITY:

			switch (position) {
			case 0:
				return "介绍";
			case 1:
				return "图片";
			default:
				throw new RuntimeException("第一层怎么能有第3个标题呢。。。");
			}
		default:
			throw new RuntimeException("出错了，枚举中没有此项...");
		}

	}

	@Override
	public int getCount() {
		switch (which) {
		case CINEMA:
			return 3;
		case MOVIE:
			return 4;
		case CELEBRITY:
			return 2;
		default:
			throw new RuntimeException("出错了，枚举中没有此项...");
		}
	}

}

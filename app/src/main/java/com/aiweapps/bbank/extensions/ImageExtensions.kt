package com.aiweapps.bbank.extensions


//fun ImageView.loadFaviconFromUrl(url: String) {
//    val context = this.context
//    Glide.with(this).load("https://www.google.com/s2/favicons?sz=64&domain_url=$url")
//        .placeholder(context.getDrawable(com.bumptech.glide.R.drawable.abc_ab_share_pack_mtrl_alpha))
//        .error(context.getDrawable(com.bumptech.glide.R.drawable.abc_btn_check_to_on_mtrl_000))
//        .listener(object : RequestListener<Drawable> {
//            override fun onLoadFailed(
//                e: GlideException?,
//                model: Any?,
//                target: Target<Drawable>,
//                isFirstResource: Boolean
//            ): Boolean {
////                second.text = url.getOrNull(0)?.uppercase() ?: ""
//                return false
//            }
//
//            override fun onResourceReady(
//                resource: Drawable,
//                model: Any,
//                target: Target<Drawable>?,
//                dataSource: DataSource,
//                isFirstResource: Boolean
//            ): Boolean {
////                second.text = ""
//                return false
//            }
//
//        }
//        )
//        .into(this)
//}
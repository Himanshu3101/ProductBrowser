package org.himanshu.productbrowser.data.remote.mapper

import org.himanshu.productbrowser.data.remote.dto.ProductDto
import org.himanshu.productbrowser.domain.model.Product
//DTo to Domain
fun ProductDto.toDomain(): Product{
    return Product(
        id = id,
        title = title,
        description = description,
        brand = brand,
        price = price,
        rating = rating,
        thumbnail = thumbnail,
        category = category
    )
}
package models.mall

import com.github.aselab.activerecord.{ActiveRecord, ActiveRecordCompanion, PlayFormSupport}
import models.ActiveRecord
import play.api.libs.json.{Json, OFormat}

case class SaleOrderDetail(
                            override val id: Long = 0L,
                            var saleOrderId: Long,
                            var saleId: Long,
                            var quantity: Int
                          ) extends ActiveRecord {
  lazy val saleOrder: ActiveRecord.BelongsToAssociation[SaleOrderDetail.this.type, SaleOrder] = belongsTo[SaleOrder]
  lazy val sale: ActiveRecord.BelongsToAssociation[SaleOrderDetail.this.type, Sale] = belongsTo[Sale]
  lazy val saleOrderDetailAttributeValues: ActiveRecord.HasManyAssociation[SaleOrderDetail.this.type, SaleOrderDetailAttributeValue] = hasMany[SaleOrderDetailAttributeValue]
}

object SaleOrderDetail extends ActiveRecordCompanion[SaleOrderDetail] with PlayFormSupport[SaleOrderDetail] {
  implicit val jsonFormat: OFormat[SaleOrderDetail] = Json.format[SaleOrderDetail]
}

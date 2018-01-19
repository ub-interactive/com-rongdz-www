package daos.default.product

import com.github.aselab.activerecord.{ActiveRecordCompanion, PlayFormSupport}
import com.github.aselab.activerecord.dsl._
import daos.ActiveRecord
import play.api.libs.json.{Json, OFormat}

case class AttributeSet(
    override val id: Long = 0L,
    var name: String,
    var description: Option[String] = None
) extends ActiveRecord {
  lazy val products: _root_.com.github.aselab.activerecord.ActiveRecord.HasManyAssociation[AttributeSet.this.type, Product] = hasMany[Product]
  lazy val attributeValueSets: _root_.com.github.aselab.activerecord.ActiveRecord.HasManyAssociation[AttributeSet.this.type, AttributeValueSet] =
    hasMany[AttributeValueSet]
  lazy val attributeSetDetails: _root_.com.github.aselab.activerecord.ActiveRecord.HasManyAssociation[AttributeSet.this.type, AttributeSetDetail] =
    hasMany[AttributeSetDetail]
}

object AttributeSet extends ActiveRecordCompanion[AttributeSet] with PlayFormSupport[AttributeSet] {
  implicit val format: OFormat[AttributeSet] = Json.format[AttributeSet]
}
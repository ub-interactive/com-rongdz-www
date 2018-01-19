package daos.default.product

import com.github.aselab.activerecord.{ActiveRecordCompanion, PlayFormSupport}
import com.github.aselab.activerecord.dsl._
import daos.ActiveRecord
import play.api.libs.json.{Json, OFormat}

case class AttributeSetDetail(
    override val id: Long = 0L,
    var attributeSetId: Long,
    var attributeId: Long,
    var sequence: Option[Int] = None
) extends ActiveRecord {
  lazy val attributeSet: _root_.com.github.aselab.activerecord.ActiveRecord.BelongsToAssociation[AttributeSetDetail.this.type, AttributeSet] =
    belongsTo[AttributeSet]
  lazy val attribute: _root_.com.github.aselab.activerecord.ActiveRecord.BelongsToAssociation[AttributeSetDetail.this.type, Attribute] =
    belongsTo[Attribute]
}

object AttributeSetDetail extends ActiveRecordCompanion[AttributeSetDetail] with PlayFormSupport[AttributeSetDetail] {
  implicit val format: OFormat[AttributeSetDetail] = Json.format[AttributeSetDetail]
}

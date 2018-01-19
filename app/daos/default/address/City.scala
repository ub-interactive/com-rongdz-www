package daos.default.address

import com.github.aselab.activerecord.{ActiveRecordCompanion, PlayFormSupport}
import daos.ActiveRecord
import play.api.libs.json.{Json, OFormat}

case class City(
    override val id: Long,
    var provinceId: Int,
    var name: String
) extends ActiveRecord {
  lazy val districts: _root_.com.github.aselab.activerecord.ActiveRecord.HasManyAssociation[
    City.this.type,
    District] =
    hasMany[District]
  lazy val province: _root_.com.github.aselab.activerecord.ActiveRecord.BelongsToAssociation[
    City.this.type,
    Province] =
    belongsTo[Province]
}

object City extends ActiveRecordCompanion[City] with PlayFormSupport[City] {
  implicit val jsonFormat: OFormat[City] = Json.format[City]
}

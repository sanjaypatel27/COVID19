package com.diyainfotech.covid19.api.india

import com.google.gson.annotations.SerializedName


data class StateWiseDataResponse(
    @SerializedName("Kerala")
    val kerala: DistrictData,

    @SerializedName("Delhi")
    val delhi: Delhi,

    @SerializedName("Telangana")
    val telangana: Telangana,

    @SerializedName("Rajasthan")
    val rajasthan: Rajasthan,

    @SerializedName("Haryana")
    val haryana: Haryana,

    @SerializedName("Uttar Pradesh")
    val uttarPradesh: DistrictData,

    @SerializedName("Ladakh")
    val ladakh: Ladakh,

    @SerializedName("Tamil Nadu")
    val tamilNadu: DistrictData,

    @SerializedName("Jammu and Kashmir")
    val jammuAndKashmir: JammuAndKashmir,

    @SerializedName("Karnataka")
    val DistrictData: DistrictData,

    @SerializedName("Maharashtra")
    val maharashtra: DistrictData,

    @SerializedName("Punjab")
    val punjab: Punjab,

    @SerializedName("Andhra Pradesh")
    val andhraPradesh: AndhraPradesh,

    @SerializedName("Uttarakhand")
    val uttarakhand: Uttarakhand,

    @SerializedName("Odisha")
    val odisha: Odisha,

    @SerializedName("Puducherry")
    val puducherry: Puducherry,

    @SerializedName("West Bengal")
    val westBengal: WestBengal,

    @SerializedName("Chandigarh")
    val chandigarh: Chandigarh,

    @SerializedName("Chhattisgarh")
    val chhattisgarh: Chhattisgarh,

    @SerializedName("Gujarat")
    val gujarat: Gujarat,

    @SerializedName("Himachal Pradesh")
    val himachalPradesh: HimachalPradesh,

    @SerializedName("Madhya Pradesh")
    val madhyaPradesh: MadhyaPradesh,

    @SerializedName("Bihar")
    val bihar: Bihar,

    @SerializedName("Manipur")
    val manipur: Manipur,

    @SerializedName("Mizoram")
    val mizoram: Mizoram,

    @SerializedName("Goa")
    val goa: Goa,

    @SerializedName("Andaman and Nicobar Islands")
    val andamanAndNicobarIslands: AndamanAndNicobarIslands,

    @SerializedName("Unknown")
    val unknown: Unknown
)


data class AndamanAndNicobarIslands (
    val districtData: AndamanAndNicobarIslandsDistrictData
)


data class AndamanAndNicobarIslandsDistrictData (
    @SerializedName("South Andaman")
    val southAndaman: District,

    @SerializedName("N&M Andaman")
    val nMAndaman: District,

    @SerializedName("Unknown")
    val unknown: District
)


data class District (
    val confirmed: Long,
    val lastupdatedtime: String
)


data class AndhraPradesh (
    val districtData: AndhraPradeshDistrictData
)


data class AndhraPradeshDistrictData (
    @SerializedName("S.P.S. Nellore")
    val sPSNellore: District,

    @SerializedName("Prakasam")
    val prakasam: District,

    @SerializedName("Visakhapatnam")
    val visakhapatnam: District,

    @SerializedName("East Godavari")
    val eastGodavari: District,

    @SerializedName("Krishna")
    val krishna: District,

    @SerializedName("Chitoor")
    val chitoor: District,

    @SerializedName("Guntur")
    val guntur: District,

    @SerializedName("Kurnool")
    val kurnool: District
)


data class Bihar (
    val districtData: BiharDistrictData
)


data class BiharDistrictData (
    @SerializedName("Munger")
    val munger: District,

    @SerializedName("Patna")
    val patna: District,

    @SerializedName("Siwan")
    val siwan: District,

    @SerializedName("Nalanda")
    val nalanda: District,

    @SerializedName("Unknown")
    val unknown: District
)


data class Chandigarh (
    val districtData: ChandigarhDistrictData
)


data class ChandigarhDistrictData (
    @SerializedName("Chandigarh")
    val chandigarh: District
)


data class Chhattisgarh (
    val districtData: ChhattisgarhDistrictData
)


data class ChhattisgarhDistrictData (
    @SerializedName("Raipur")
    val raipur: District,

    @SerializedName("Rajnandgaon")
    val rajnandgaon: District,

    @SerializedName("Bilaspur")
    val bilaspur: District,

    @SerializedName("Durg")
    val durg: District,

    @SerializedName("Unknown")
    val unknown: District
)


data class Delhi (
    val districtData: DelhiDistrictData
)


data class DelhiDistrictData (
    @SerializedName("East Delhi")
    val eastDelhi: District,

    @SerializedName("South West Delhi")
    val southWestDelhi: District,

    @SerializedName("West Delhi")
    val westDelhi: District,

    @SerializedName("Delhi")
    val delhi: District,

    @SerializedName("South Delhi")
    val southDelhi: District,

    @SerializedName("North East Delhi")
    val northEastDelhi: District,

    @SerializedName("North Delhi")
    val northDelhi: District,

    @SerializedName("North West Delhi")
    val northWestDelhi: District,

    @SerializedName("Unknown")
    val unknown: District
)


data class Goa (
    val districtData: GoaDistrictData
)


data class GoaDistrictData (
    @SerializedName("North Goa")
    val northGoa: District
)


data class Gujarat (
    val districtData: GujaratDistrictData
)


data class GujaratDistrictData (
    @SerializedName("Rajkot")
    val rajkot: District,

    @SerializedName("Surat")
    val surat: District,

    @SerializedName("Ahmedabad")
    val ahmedabad: District,

    @SerializedName("Vadodara")
    val vadodara: District,

    @SerializedName("Gandhinagar")
    val gandhinagar: District,

    @SerializedName("Kutch")
    val kutch: District,

    @SerializedName("Unknown")
    val unknown: District,

    @SerializedName("Mehsana")
    val mehsana: District
)


data class Haryana (
    val districtData: HaryanaDistrictData
)


data class HaryanaDistrictData (
    @SerializedName("Gurugram")
    val gurugram: District,

    @SerializedName("Faridabad")
    val faridabad: District,

    @SerializedName("Panipat")
    val panipat: District,

    @SerializedName("Panchkula")
    val panchkula: District,

    @SerializedName("Sonepat")
    val sonepat: District,

    @SerializedName("Palwal")
    val palwal: District,

    @SerializedName("Ambala")
    val ambala: District
)


data class HimachalPradesh (
    val districtData: HimachalPradeshDistrictData
)


data class HimachalPradeshDistrictData (
    @SerializedName("Kangra")
    val kangra: District
)


data class JammuAndKashmir (
    val districtData: JammuAndKashmirDistrictData
)


data class JammuAndKashmirDistrictData (
    @SerializedName("Unknown")
    val unknown: District,

    @SerializedName("Jammu")
    val jammu: District,

    @SerializedName("Srinagar")
    val srinagar: District,

    @SerializedName("Bandipore")
    val bandipore: District,

    @SerializedName("Rajouri")
    val rajouri: District,

    @SerializedName("Bandipora")
    val bandipora: District
)


data class DistrictData (
    val districtData: Map<String, District>
)


data class Ladakh (
    val districtData: LadakhDistrictData
)


data class LadakhDistrictData (
    @SerializedName("Leh")
    val leh: District,

    @SerializedName("Kargil")
    val kargil: District
)


data class MadhyaPradesh (
    val districtData: MadhyaPradeshDistrictData
)


data class MadhyaPradeshDistrictData (
    @SerializedName("Jabalpur")
    val jabalpur: District,

    @SerializedName("Bhopal")
    val bhopal: District,

    @SerializedName("Indore")
    val indore: District,

    @SerializedName("Ujjain")
    val ujjain: District,

    @SerializedName("Gwalior")
    val gwalior: District,

    @SerializedName("Shivpuri")
    val shivpuri: District,

    @SerializedName("Unknown")
    val unknown: District
)


data class Manipur (
    val districtData: ManipurDistrictData
)


data class ManipurDistrictData (
    @SerializedName("Imphal West")
    val imphalWest: District
)


data class Mizoram (
    val districtData: MizoramDistrictData
)


data class MizoramDistrictData (
    @SerializedName("Aizawl")
    val aizawl: District
)


data class Odisha (
    val districtData: OdishaDistrictData
)


data class OdishaDistrictData (
    @SerializedName("Khordha")
    val khordha: District
)


data class Puducherry (
    val districtData: PuducherryDistrictData
)


data class PuducherryDistrictData (
    @SerializedName("Mahe")
    val mahe: District
)


data class Punjab (
    val districtData: PunjabDistrictData
)


data class PunjabDistrictData (
    @SerializedName("Amritsar")
    val amritsar: District,

    @SerializedName("Shaheed Bhagat Singh Nagar")
    val shaheedBhagatSinghNagar: District,

    @SerializedName("Sahibzada Ajit Singh Nagar")
    val sahibzadaAjitSinghNagar: District,

    @SerializedName("Hoshiarpur")
    val hoshiarpur: District,

    @SerializedName("Jalandhar")
    val jalandhar: District,

    @SerializedName("Unknown")
    val unknown: District,

    @SerializedName("Ludhiana")
    val ludhiana: District
)


data class Rajasthan (
    val districtData: RajasthanDistrictData
)


data class RajasthanDistrictData (
    @SerializedName("Jaipur")
    val jaipur: District,

    @SerializedName("Jhunjhunu")
    val jhunjhunu: District,

    @SerializedName("Bhilwara")
    val bhilwara: District,

    @SerializedName("Jodhpur")
    val jodhpur: District,

    @SerializedName("Unknown")
    val unknown: District,

    @SerializedName("Pratapgarh ")
    val pratapgarh: District,

    @SerializedName("Ajmer")
    val ajmer: District
)


data class Telangana (
    val districtData: TelanganaDistrictData
)


data class TelanganaDistrictData (
    @SerializedName("Hyderabad")
    val hyderabad: District,

    @SerializedName("Karimnagar")
    val karimnagar: District,

    @SerializedName("Bhadradri Kothagudem")
    val bhadradriKothagudem: District,

    @SerializedName("Ranga Reddy")
    val rangaReddy: District,

    @SerializedName("Medchal Malkajgiri")
    val medchalMalkajgiri: District,

    @SerializedName("Unknown")
    val unknown: District
)


data class Unknown (
    val districtData: UnknownDistrictData
)


data class UnknownDistrictData (
    @SerializedName("Unknown")
    val unknown: District
)


data class Uttarakhand (
    val districtData: UttarakhandDistrictData
)


data class UttarakhandDistrictData (
    @SerializedName("Dehradun")
    val dehradun: District,

    @SerializedName("Pauri")
    val pauri: District
)


data class WestBengal (
    val districtData: WestBengalDistrictData
)


data class WestBengalDistrictData (
    @SerializedName("Kolkata")
    val kolkata: District,

    @SerializedName("North 24 Parganas")
    val north24Parganas: District,

    @SerializedName("Nadia")
    val nadia: District,

    @SerializedName("Unknown")
    val unknown: District
)
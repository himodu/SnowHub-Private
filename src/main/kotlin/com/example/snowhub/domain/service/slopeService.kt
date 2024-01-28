//package com.example.snowhub.domain.service
//
//import com.example.snowhub.domain.model.Resort
//import com.example.snowhub.domain.model.Slope
//import com.example.snowhub.infrastructure.SlopeEntity
//import com.example.snowhub.domain.repository.SlopeRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class slopeService(
//        private val slopeRepository: SlopeRepository
) {
//    fun getAllSlopes(): List<Slope> {
//        return slopeRepository.findAll().map { it.toSlope() }
//    }
//
//    fun getSlopesByResortID(resortID: Int): List<Slope> {
//        return slopeRepository.findByResortID(resortID).map { it.toSlope() }
//    }
//
//    fun getSlopesByDifficulty(difficulty: String): List<Slope> {
//        return slopeRepository.findByDifficulty(difficulty).map { it.toSlope() }
//    }
//
//    fun getSlopeBySlopeName(slopeName: String): Slope? {
//        return slopeRepository.findBySlopeName(slopeName).toSlope()
//    }
//
//    fun getSlopeBySlopeId(slopeId: UUID): Slope? {
//        return slopeRepository.findById(slopeId).get().toSlope()
//    }
//
//    fun getIDBySlopeName(slopeName: String): UUID? {
//        val slopeEntity = slopeRepository.findBySlopeName(slopeName)
//        return UUID.fromString(slopeEntity.id)
//    }
//
//    fun updateSlopes(resort: Resort) {
//        resort.slopeInfo.forEach {
//            val slopeEntity = SlopeEntity(
//                    id = it.slope.slopeID,
//                    slopeName = it.slope.slopeName,
//                    resortID = it.slope.resortID,
//                    difficulty = it.slope.difficulty
//            )
//            slopeRepository.save(slopeEntity)
//        }
//    }
//
//    private fun SlopeEntity.toSlope(): Slope {
//        return Slope(
//                slopeID = this.id,
//                slopeName = this.slopeName,
//                resortID = this.resortID,
//                difficulty = this.difficulty
//        )
//    }
}
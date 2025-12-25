@Service
public class AlertScheduleServiceImpl implements AlertScheduleService {

    private final AlertScheduleRepository repo;
    private final WarrantyRepository warrantyRepo;

    public AlertScheduleServiceImpl(AlertScheduleRepository repo, WarrantyRepository warrantyRepo) {
        this.repo = repo;
        this.warrantyRepo = warrantyRepo;
    }

    @Override
    public AlertSchedule createSchedule(Long warrantyId, AlertSchedule schedule) {
        Warranty warranty = warrantyRepo.findById(warrantyId).orElseThrow();
        schedule.setWarranty(warranty);
        return repo.save(schedule);
    }

    @Override
    public List<AlertSchedule> getSchedules(Long warrantyId) {
        return repo.findByWarrantyId(warrantyId);
    }
}

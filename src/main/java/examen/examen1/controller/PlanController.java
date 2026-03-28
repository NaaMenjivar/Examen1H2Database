package examen.examen1.controller;

import examen.examen1.model.*;
import examen.examen1.service.*;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/plan")
public class PlanController {

    private final PacienteService pacienteService;
    private final PacienteMedicamentoService pmService;
    private final MedicamentoService medicamentoService;
    private final FarmaciaService farmaciaService;
    private final UsuarioService usuarioService;

    public PlanController(PacienteService pacienteService,
                          PacienteMedicamentoService pmService,
                          MedicamentoService medicamentoService,
                          FarmaciaService farmaciaService,
                          UsuarioService usuarioService) {
        this.pacienteService = pacienteService;
        this.pmService = pmService;
        this.medicamentoService = medicamentoService;
        this.farmaciaService = farmaciaService;
        this.usuarioService = usuarioService;
    }

    @GetMapping("/show")
    public String show(@AuthenticationPrincipal UserDetails userDetails,
                       @RequestParam(required = false) String cedula,
                       @RequestParam(required = false) String error,
                       Model model) {

        Usuario usuario = usuarioService.buscarPorId(userDetails.getUsername());
        Farmacia farmacia = farmaciaService.buscarPorUsuario(usuario);
        model.addAttribute("farmacia", farmacia);

        if (cedula != null && !cedula.isBlank()) {
            Paciente paciente = pacienteService.buscarPorId(cedula);
            model.addAttribute("paciente", paciente);

            if (paciente != null) {
                List<PacienteMedicamento> medicamentos = pmService.buscarPorPaciente(paciente);
                model.addAttribute("medicamentos", medicamentos);
            }
            model.addAttribute("cedula", cedula);
        }

        if (error != null) {
            model.addAttribute("errorMsg", "No hay dosis suficientes a favor para entregar");
        }

        return "plan";
    }

    @PostMapping("/registrar")
    public String registrar(@RequestParam Integer pmId,
                            @RequestParam Integer cantidad,
                            @RequestParam(required = false) String cedula) {
        PacienteMedicamento pm = pmService.buscarPorId(pmId);
        pm.setDosisafavor(pm.getDosisafavor() + cantidad);
        pmService.guardar(pm);
        return "redirect:/plan/show?cedula=" + cedula;
    }

    @PostMapping("/entregar")
    public String entregar(@RequestParam Integer pmId,
                           @RequestParam Integer cantidad,
                           @RequestParam(required = false) String cedula) {
        PacienteMedicamento pm = pmService.buscarPorId(pmId);
        int dosisNecesarias = pm.getMedicamento().getPlan() * cantidad;
        if (pm.getDosisafavor() >= dosisNecesarias) {
            pm.setDosisafavor(pm.getDosisafavor() - dosisNecesarias);
            pmService.guardar(pm);
            return "redirect:/plan/show?cedula=" + cedula;
        } else {
            return "redirect:/plan/show?cedula=" + cedula + "&error=1";
        }
    }
}
